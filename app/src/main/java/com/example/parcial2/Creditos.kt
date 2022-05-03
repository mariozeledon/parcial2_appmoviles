package com.example.parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Creditos : AppCompatActivity() {

    var credito = listOf<Datos>(
        Datos("Universidad de San Carlos de Guatemala","201805909", "Mario Roberto Morales Zeledón","https://lh3.googleusercontent.com/e0jN6sSIEao69hZZWeR-p-Uy1B10UfvEMutMwtxwu7FxFL4tYGKSGHBrbBwYGhuupauhQem5IPfbH3ROi_VEFvrB-2dddSSOL5ZqDGRm2PMS8oedatpDjPHlOOjmCNu9YGclOMtWmIpsRVqQ-uxxla6NlFbXNetPLsGEplfz-wgeBYytTehTW-84wySqSI3jpYblJwR9qehQ9RcbhSzZR6B9Er5Y5Y9vodgFp624cDB9omLkI5b2_pO0dx8tDj2t3YuxBwhwp-snomzf7tLwmIKLnAvFk6ZwMNnYe7OQK5gPMa1CCot8N78aDRL5YDbWbXHzWqnK518vTvMTt16JQ_QoS8CbpXnOaNEs6ie5APA7_HmY7cZuVL3v2UOumNO7fS-YSyU6lbiDhAwCm3YQB9gtNgm-Nu4kUlnYr87CGj-yWEo_zgrvXck6VGrj0ok2hPte5bu6_Vl9ezs_uN9VlBj3DQSPFsUyWPW9JPWiEmIoBfraXrjL6xedlXDrtM-mLA9pM6YxyKnadK85ik3-KI_G1llFABxkMKybZVAVsDgL8UwayPDIwlu-rUXbbibtgAP65-Xuto95at36NNGhZDATfy9qsdRRgEflDLGD-RIapYUVIbeE1jYRjrdPxSU8N-VKj-SalKpIACiSWWN390TQ4xF5-_6K48m2_juWg3yLCWRLO3qLw-kNFknUlcbomo07ORo5dTe08xNUVS8PXGXeK-odZ11Jm75ALifbm8eOmpd00zpjBUFww7CdZ0caDqsEPOnyVIjvLMfKlMoqrh8qBnQ0l5GF7lBJJ-TaMB6CfCdOhaR4jqTfa6QlmW7QYr6gfIhdia98O5cyM5wHkSGdnRpAfCzmAHZsEiBgQUNGGoPIMCP0NDrlfMdHD-uftvl12qlQ=s640-no?authuser=0")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creditos)

        val recyclerCredito = findViewById<RecyclerView>(R.id.rvCredito_creditos)
        val adaptadorCredito = Adaptador_Credito(credito)
        recyclerCredito.layoutManager = LinearLayoutManager(this)
        recyclerCredito.adapter = adaptadorCredito
    }
}
