package com.ai.doc.mediator.v1;

import javax.swing.text.View;
import java.awt.*;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class UIControl {
    private static final String LOGIN_BIN_ID = "loin_btn";
    private static final String REG_BIN_ID = "reg_btn";
    private static final String USERNAME_INPUT_ID = "username_input";
    private static final String PASSWORD_INPUT_ID = "pswd_input";
    private static final String REPEATED_PASSWORD_INPUT_ID = "repeated_pswd_input";
    private static final String HINT_TEXT_ID = "hint_text";
    private static final String SELECTION_ID = "selection";

    public static void main(String[] args) {
        Button loginButton = (Button)findViewById(LOGIN_BIN_ID); 
        Button regButton = (Button)findViewById(REG_BIN_ID); 
        final Input usernameInput = (Input) findViewById(USERNAME_INPUT_ID); 
        final Input passwordInput = (Input) findViewById(PASSWORD_INPUT_ID); 
        Input repeatedPswdInput = (Input) findViewById(REPEATED_PASSWORD_INPUT_ID); 
        Text hintText = (Text) findViewById(HINT_TEXT_ID);
        Selection selection = (Selection)findViewById(SELECTION_ID);
        
        loginButton.setOnclickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                String username = usernameInput.text();
                String password = passwordInput.text();
                //校验数据...
                //做业务处理...
            }
        });
        
        regButton.setOnclickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                //获取usernameInput passwordInput repeatedPswdInput数据...
                //校验数据...
                //做业务处理...
            }
        });
        
        //...省略selection下拉选择框相关代码...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
