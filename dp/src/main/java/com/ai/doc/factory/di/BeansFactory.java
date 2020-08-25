package com.ai.doc.factory.di;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/14
 * @Version: 1.0
 **/
public class BeansFactory {
    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();
    
    public void addBeanDefinition(List<BeanDefinition> beanDefinitionList){
        for (BeanDefinition beanDefinition:beanDefinitionList){
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(),beanDefinition);
        }
        
        for (BeanDefinition beanDefinition:beanDefinitionList){
            if (beanDefinition.isLazyInit() == false && beanDefinition.isSingleton()){
                createBean(beanDefinition);
            }
        }
    }
    
    public Object getBean(String beanId){
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null){
            throw new NoSuchBeanDefinitionException("Bean is not defined: "+beanId);
        }
        return createBean(beanDefinition);
    }
    
    @VisibleForTesting
    protected Object createBean(BeanDefinition beanDefinition){
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition)){
            return singletonObjects.get(beanDefinition.getId());
        }
        
        Object bean = null;
        try{
            Class beanClass = Class.forName(beanDefinition.getBeanClassName());
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgumentValues();
            if (args.isEmpty()){
                bean = beanClass.newInstance();
            }else{
                Class[] argClasses = new Class[args.size()];
                Object[] argObjects = new Object[args.size()];
                for (int i = 0; i<args.size();i++){
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if (!arg.getIsRef()){
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    }else{
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null){
                            throw new NoSuchBeanDefinitionException("Bean is not defined: "+refBeanDefinition);
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getBeanClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        }catch (ClassNotFoundException e){
            throw new BeanCreationException("",e);
        }
        
        if (bean != null && beanDefinition.isSingleton()){
            singletonObjects.putIfAbsent(beanDefinition.getId(),bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
