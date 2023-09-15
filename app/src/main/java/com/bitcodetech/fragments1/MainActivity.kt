package com.bitcodetech.fragments1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitcodetech.fragments1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var stockMarketFragment1: StockMarketFragment
    private lateinit var stockMarketFragment2: StockMarketFragment

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        stockMarketFragment1 =
            supportFragmentManager.findFragmentById(R.id.stockMarketFragment1) as StockMarketFragment
        stockMarketFragment2 =
            supportFragmentManager.findFragmentById(R.id.stockMarketFragment2) as StockMarketFragment

        binding.btnStop.setOnClickListener {
            stockMarketFragment1.state = false
            stockMarketFragment2.state = false
        }

        binding.btnStart.setOnClickListener {
            stockMarketFragment1.state = true
            stockMarketFragment2.state = true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}