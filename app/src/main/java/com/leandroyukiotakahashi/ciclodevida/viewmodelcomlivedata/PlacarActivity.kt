package com.leandroyukiotakahashi.ciclodevida.viewmodelcomlivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.leandroyukiotakahashi.ciclodevida.R
import kotlinx.android.synthetic.main.activity_placar.*

class PlacarActivity : AppCompatActivity() {

    var placarViewModel: PlacarViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        placarViewModel = ViewModelProviders.of(this)
                .get(PlacarViewModel::class.java)

        placarViewModel?.placarVisitante?.observe(this, Observer { tvPlacarTimeB.text = it?.toString() })
        placarViewModel?.placarCasa?.observe(this, Observer { tvPlacarTimeA.text = it?.toString()})

        bt1PontoTimeA.setOnClickListener{
                placarViewModel?.pontoCasa(1)}
        bt2PontoTimeA.setOnClickListener{
            placarViewModel?.pontoCasa(2)}
        bt3PontoTimeA.setOnClickListener{
            placarViewModel?.pontoCasa(3)}
        bt1PontoTimeB.setOnClickListener{
            placarViewModel?.pontoVisitante(1)}
        bt1PontoTimeB.setOnClickListener{
            placarViewModel?.pontoVisitante(2)}
        bt1PontoTimeB.setOnClickListener{
            placarViewModel?.pontoVisitante(3)}

        btReiniciar.setOnClickListener {
            placarViewModel?.reiniciar()
        }
    }
}
