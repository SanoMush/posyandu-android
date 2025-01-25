package com.sanomush.posyandu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.sanomush.posyandu.R
import com.sanomush.posyandu.ui.fitur.ConsultationFragment
import com.sanomush.posyandu.ui.fitur.DataPosyanduFragment
import com.sanomush.posyandu.ui.fitur.InformasiFragment
import com.sanomush.posyandu.ui.fitur.ServiceFragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_home
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Card Informasi Kegiatan
        val cardInformasiKegiatan = view.findViewById<CardView>(R.id.cardInformasiKegiatan)
        cardInformasiKegiatan?.setOnClickListener {
            // Replace fragment with InformasiFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, InformasiFragment())
                .addToBackStack(null)
                .commit()
        }

        // Card Layanan Kesehatan
        val cardLayananKesehatan = view.findViewById<CardView>(R.id.cardLayananKesehatan)
        cardLayananKesehatan?.setOnClickListener {
            // Replace fragment with ServiceFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ServiceFragment())
                .addToBackStack(null)
                .commit()
        }

        // Card Data Posyandu
        val cardDataPosyandu = view.findViewById<CardView>(R.id.cardDataPosyandu)
        cardDataPosyandu?.setOnClickListener {
            // Replace fragment with DataPosyanduFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DataPosyanduFragment())
                .addToBackStack(null)
                .commit()
        }

        // Card Konsultasi
        val cardKonsultasi = view.findViewById<CardView>(R.id.cardKonsultasi)
        cardKonsultasi?.setOnClickListener {
            // Replace fragment with ConsultationFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ConsultationFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
