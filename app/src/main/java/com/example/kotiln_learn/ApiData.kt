package com.example.kotiln_learn


data class ApiData(
    val resultCode: String,
    val resultMessage: String,
    val busan: CountryState,
    val chungbuk: CountryState,
    val chungnam: CountryState,
    val daegu: CountryState,
    val daejeon: CountryState,
    val gangwon: CountryState,
    val gwangju: CountryState,
    val gyeongbuk: CountryState,
    val gyeonggi: CountryState,
    val gyeongnam: CountryState,
    val incheon: CountryState,
    val jeju: CountryState,
    val jeonbuk: CountryState,
    val jeonnam: CountryState,
    val korea: CountryState,
    val quarantine: CountryState,
    val sejong: CountryState,
    val seoul: CountryState,
    val ulsan: CountryState
)
data class CountryState(
    val countryName: String,
    val death: String,
    val newCase: String,
    val newCcase: String,
    val newFcase: String,
    val percentage: String,
    val recovered: String,
    val totalCase: String
)