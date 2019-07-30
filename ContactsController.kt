package com.example.apiarchitecture.controller

import com.example.apiarchitecture.model.Contacts
import com.example.apiarchitecture.model.ResModelContacts
import com.google.gson.Gson
import org.json.JSONObject

class ContactsController : BaseController() {
    override fun onPopulate(objJson: JSONObject?) {
        var contacts : ResModelContacts = Gson().fromJson(objJson.toString(),ResModelContacts::class.java)
        this.mCallBackListener.handleSuccessData(contacts)
    }

    override fun startFetching(callBackListner: CallBackListener) {
        super.startFetching(callBackListner)
        this.mCallBackListener = callBackListner
        callRequestToServer(mApiService.getAllContacts())
    }
}