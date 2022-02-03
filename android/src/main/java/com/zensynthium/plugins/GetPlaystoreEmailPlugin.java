package com.zensynthium.plugins;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import static android.app.Activity.RESULT_OK;

import android.accounts.AccountManager;
import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResult;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.common.AccountPicker;

import java.util.Arrays;

@CapacitorPlugin(name = "GetPlaystoreEmail")
public class GetPlaystoreEmailPlugin extends Plugin {

//    private GetPlaystoreEmail implementation = new GetPlaystoreEmail();
//
//    @PluginMethod
//    public void echo(PluginCall call) {
//        String value = call.getString("value");
//
//        JSObject ret = new JSObject();
//        ret.put("value", implementation.echo(value));
//        call.resolve(ret);
//    }

    @PluginMethod()
    public void getAccount(PluginCall call) {
//        Log.i("EmailRes", "Function Called!");
        Intent intent =
                AccountPicker.newChooseAccountIntent(
                        new AccountPicker.AccountChooserOptions.Builder()
                                .setAllowableAccountsTypes(Arrays.asList("com.google"))
                                .build());
        startActivityForResult(call, intent, "saveEmail");
    }

    @ActivityCallback
    private void saveEmail(PluginCall call, ActivityResult result) {
//      Log.i("EmailRes", "Callback Called!");
        if (result.getResultCode() == RESULT_OK) {
            String accountName = result.getData().getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
//            Log.i("EmailRes", accountName);
            JSObject ret = new JSObject();
//            ret.put("value", value);
//            Log.i("EmailRes","Result is okay!");
            ret.put("email", accountName);
            call.resolve(ret);
        } else {
//            Log.i("EmailRes","Something went wrong, failed.");
        }
    }
}


