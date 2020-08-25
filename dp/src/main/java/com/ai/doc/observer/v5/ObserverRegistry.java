package com.ai.doc.observer.v5;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/21
 * @Version: 1.0
 **/
public class ObserverRegistry {
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry;
    public void register(Object observer){
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>,Collection<ObserverAction>> entry:observerActions.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null){
                registry.putIfAbsent(eventType,new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
        
    }
    
    public List<ObserverAction> getMatchedObserverActions(Object event){
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>,CopyOnWriteArraySet<ObserverAction>> entry:registry.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)){
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }
    
    private Map<Class<?>,Collection<ObserverAction>> findAllObserverActions(Object observer){
        Map<Class<?>,Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method: getAnnotatedMethod(clazz)){
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)){
                observerActions.put(eventType,new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer,method));
        }
        return observerActions;
    }
    private List<Method> getAnnotatedMethod(Class<?> clazz){
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method: clazz.getDeclaredMethods()){
            if (method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                +"Subscriber methods must have exactly 1 parameter.",method,parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
