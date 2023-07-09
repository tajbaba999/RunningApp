package com.androiddevs.runningappyt.ui.fragments

import android.app.Dialog
import android.net.wifi.p2p.WifiP2pManager.NetworkInfoListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.androiddevs.runningappyt.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog :DialogFragment() {

    private var yesListner : (() -> Unit) ? = null

    fun setYesListner(listener: () -> Unit){
        yesListner = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return  MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure to cancel the current run and delete all its data?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes") { _, _ ->
               yesListner?.let {yes ->
                    yes()
               }
            }
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }
}