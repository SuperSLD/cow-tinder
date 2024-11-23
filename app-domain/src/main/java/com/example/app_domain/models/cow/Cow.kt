package com.example.app_domain.models.cow

import com.fasterxml.jackson.annotation.JsonProperty

data class Cow(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("sex")
    val sex: String,

    @JsonProperty("breed")
    val breed: String,

    @JsonProperty("birth_date")
    val birthDate: String,

    @JsonProperty("papa")
    val papa: String,

    @JsonProperty("mama")
    val mama: String,

    @JsonProperty("milk_volume")
    val milkVolume: String,

    @JsonProperty("meat_volume")
    val meatVolume: String,

    @JsonProperty("inbreeding")
    val inbreeding: String,

    @JsonProperty("meat_increment")
    val meatIncrement: String,

    @JsonProperty("health")
    val health: String,

    @JsonProperty("fertility")
    val fertility: String,

    @JsonProperty("genetic_value")
    val geneticValue: String
)
