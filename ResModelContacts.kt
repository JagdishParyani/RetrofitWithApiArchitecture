package com.example.apiarchitecture.model


data class ResModelContacts(var contacts : List<Contacts>) : BaseModel()

data class Contacts (
    var id : String,
    var name : String,
    var email : String,
    var address : String,
    var gender : String,
    var phone : Phone
) : BaseModel()

data class Phone (
    var mobile : String,
    var home : String,
    var office : String
) : BaseModel()