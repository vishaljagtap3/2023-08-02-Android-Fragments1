package com.bitcodetech.fragments1

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.fragments1.databinding.StockMarketFragmentBinding
import kotlin.random.Random

class StockMarketFragment : Fragment() {

    private lateinit var binding: StockMarketFragmentBinding
    var state = true
    set(value) {
        if(!field && value) {
            field = value
            StockMarketThread().execute(null)
        }
        if(!value) {
            field = value
        }
    }

    private var bseIndexValue = 66000
        set(value) {
            field = value
            binding.txtBseIndexValue.text = "$field"
        }
    private var nseIndexValue = 20000
        set(value) {
            field = value
            binding.txtNseIndexValue.text = "$field"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = StockMarketFragmentBinding.bind(
            inflater.inflate(R.layout.stock_market_fragment, null)
        )

        binding.btnStop.setOnClickListener {
            state = false
        }

        //Start a thread
        StockMarketThread().execute(null)

        return binding.root
    }

    private inner class StockMarketThread : AsyncTask<Any, Int, Any>() {

        override fun doInBackground(vararg p0: Any?): Any? {
            while (state) {
                Thread.sleep(1000)
                publishProgress(null)
            }

            return null
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            bseIndexValue += Random.nextInt().mod(25)
            nseIndexValue += Random.nextInt().mod(25)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

}