package com.ai;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DarkLauch darkLauch = new DarkLauch();
        DarkFeature darkFeature = darkLauch.getDarkFeature("call_newapi_getUserById");
        System.out.println(darkFeature.enabled());
        System.out.println(darkFeature.dark(893));
    }
}
