/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvirtual.api.service;

import com.bvirtual.api.model.ResponseModel;
import com.bvirtual.engine.Main;
import com.bvirtual.sms.model.InfobibResponseModel;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

//import com.twilio.Twilio;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Bsystems
 */
public class SMSService {

//    public static ResponseModel validateSMSCode(String to, String code) {
//
//        ResponseModel defaultSuccess = ResponseModel.defaultSuccess("accounts", "sms code validation");
//        defaultSuccess.setRecordId(to);
//        if (Main.engine.getProperties().getProperty("SMSProvider").equalsIgnoreCase("infobib")) {
//            InfobibResponseModel infobibResponseModel = null;
//            Response response = null;
//            if (Main.engine.getProperties().getProperty("infobibURL") != null && !Main.engine.getProperties().getProperty("infobibURL").equals("")) {
//
//            }
//        } else if (Main.engine.getProperties().getProperty("SMSProvider").equalsIgnoreCase("twilio")) {
//            try {
//                com.twilio.Twilio.init(Main.engine.getProperties().getProperty("twilioAccountSID"), Main.engine.getProperties().getProperty("twilioAuthToken"));
//                com.twilio.rest.verify.v2.service.VerificationCheck create = com.twilio.rest.verify.v2.service.VerificationCheck.creator(
//                        Main.engine.getProperties().getProperty("twilioServiceSID"),
//                        code).setTo(to).create();
//                defaultSuccess.setMessage(create.getStatus());
//            } catch (Exception ex) {
//                defaultSuccess.setSuccess(false);
//                defaultSuccess.setMessage(ex.getMessage());
//            }
////            if (defaultSuccess.getMessage().toLowerCase().contains("approved")){// || defaultSuccess.getMessage().toLowerCase().contains("sent")) {
////                defaultSuccess.setMessage("Code sent");
////            }
//        }
//        return defaultSuccess;
//
//    }
//
//    public static ResponseModel validateMobileNumber(String to, String message) {
//
//        ResponseModel defaultSuccess = ResponseModel.defaultSuccess("accounts", "mobilenumber verification");
//        defaultSuccess.setRecordId(to);
//        try {
//            com.twilio.Twilio.init(Main.engine.getProperties().getProperty("twilioAccountSID"), Main.engine.getProperties().getProperty("twilioAuthToken"));
//            com.twilio.rest.verify.v2.service.Verification create = com.twilio.rest.verify.v2.service.Verification.creator(
//                    Main.engine.getProperties().getProperty("twilioServiceSID"),
//                    to,
//                    Main.engine.getProperties().getProperty("twilioServiceChannel")
//            ).create();
//            defaultSuccess.setMessage(create.getStatus());
//        } catch (Exception ex) {
//            defaultSuccess.setSuccess(false);
//            defaultSuccess.setMessage(ex.getMessage());
//        }
//        if (defaultSuccess.getMessage().toLowerCase().contains("queued") || defaultSuccess.getMessage().toLowerCase().contains("sent")) {
//            defaultSuccess.setMessage("Code sent");
//        }
//        return defaultSuccess;
//    }

    public static ResponseModel sendSMS(String to, String message) {

        ResponseModel defaultSuccess = ResponseModel.defaultSuccess("accounts", "mobilenumber verification");
        //defaultSuccess.setRecordId(to);
        if (Main.engine.getProperties().getProperty("SMSProvider").equalsIgnoreCase("infobib")) {
            InfobibResponseModel infobibResponseModel = null;
            Response response = null;
            if (Main.engine.getProperties().getProperty("infobibURL") != null && !Main.engine.getProperties().getProperty("infobibURL").equals("")) {
                ClientConfig config = new ClientConfig();
                config.register(JacksonJsonProvider.class);
                Client newClient = ClientBuilder.newClient(config);
                String property = String.format(Main.engine.getProperties().getProperty("infobibURL"), to, message);
                System.out.println(property);
                try {
                    response = newClient.target(property)
                            .request()
                            .get();
                    System.out.println(property);
                } catch (Exception e) {
//                System.out.println();
//                System.out.println();
                    System.out.println(e.getMessage());
                }
                if (response.getStatus() == 200) {
                    infobibResponseModel = response.readEntity(InfobibResponseModel.class);
                    defaultSuccess.setMessage(infobibResponseModel.getMessages().get(0).getStatus().getDescription());
                } else {
                    defaultSuccess.setSuccess(false);
                    defaultSuccess.setMessage("error sending sms");
                    //return null;
//                return ResponseModel.defaultFailure(response.getStatusInfo().getReasonPhrase(), "account", "mobile number verification");
                }
            }
            // return defaultSuccess;
            //return false;
        } 

        if (defaultSuccess.getMessage().toLowerCase().contains("queued") || defaultSuccess.getMessage().toLowerCase().contains("sent")) {
            defaultSuccess.setMessage("Code sent");
        }
        return defaultSuccess;
    }

}
