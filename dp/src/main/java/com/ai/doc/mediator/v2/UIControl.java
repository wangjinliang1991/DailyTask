package com.ai.doc.mediator.v2;

import com.ai.doc.mediator.v1.Input;
import com.ai.doc.mediator.v1.Selection;
import com.ai.doc.mediator.v1.Text;

import javax.print.attribute.standard.Media;
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
        final Button loginButton = (Button)findViewById(LOGIN_BIN_ID);
        final Button regButton = (Button)findViewById(REG_BIN_ID);
        Input usernameInput = (Input) findViewById(USERNAME_INPUT_ID);
        Input passwordInput = (Input) findViewById(PASSWORD_INPUT_ID);
        Input repeatedPswdInput = (Input) findViewById(REPEATED_PASSWORD_INPUT_ID);
        Text hintText = (Text) findViewById(HINT_TEXT_ID);
        Selection selection = (Selection)findViewById(SELECTION_ID);

        final Mediator dialog = new LandingPageDialog();
        dialog.setLoginButton(loginButton);
        dialog.setRegButton(regButton);
        dialog.setUsernameInput(usernameInput);
        dialog.setPasswordInput(passwordInput);
        dialog.setRepeatedPswdInput(repeatedPswdInput);
        dialog.setHintText(hintText);
        dialog.setSelection(selection);
        
        loginButton.setOnclickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.handleEvent(loginButton,"click");
            }
        });

        regButton.setOnclickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.handleEvent(regButton,"click");
            }
        });
        //...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
