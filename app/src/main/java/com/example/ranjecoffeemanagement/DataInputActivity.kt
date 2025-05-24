package com.example.ranjecoffeemanagement

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.semantics.setText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class DataInputActivity : AppCompatActivity() {
    lateinit var blockname: EditText
    lateinit var startdate: EditText
    lateinit var acreage:EditText
    lateinit var numbushes:EditText
    lateinit var editorgmanure: CheckBox
    lateinit var editlaborgmanure:EditText
    lateinit var editnorgmanure:CheckBox
    lateinit var editlabnorgmanure:EditText
    lateinit var editweeding:CheckBox
    lateinit var editlabweeding:EditText
    lateinit var editpruning:CheckBox
    lateinit var editlabpruning:EditText
    lateinit var editspraying:CheckBox
    lateinit var editlabspraying:EditText
    lateinit var editcherrypick:CheckBox
    lateinit var editlabcherrypick:EditText
    lateinit var edittransport:CheckBox
    lateinit var editlabtransport:EditText
    lateinit var editmilling:CheckBox
    lateinit var editlabmilling:EditText
    lateinit var editdrying:CheckBox
    lateinit var editlabdrying:EditText
    lateinit var editsorting:CheckBox
    lateinit var editlabsorting:EditText
    lateinit var instruction_id:TextView
    lateinit var submitbutton:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_input)

        blockname = findViewById(R.id.edtblockname)
        startdate = findViewById(R.id.edtstartdate)
        acreage = findViewById(R.id.edtacreage)
        numbushes = findViewById(R.id.edtbushesnum)
        editorgmanure = findViewById(R.id.edtorgmanure)
        editlaborgmanure = findViewById(R.id.edtlaborgmanure)
        editnorgmanure = findViewById(R.id.edtnorgmanure)
        editlabnorgmanure = findViewById(R.id.edtlabnorgmanure)
        editweeding = findViewById(R.id.edtweeding)
        editlabweeding = findViewById(R.id.edtlabweeding)
        editpruning = findViewById(R.id.edtpruning)
        editlabpruning = findViewById(R.id.edtlabpruning)
        editspraying = findViewById(R.id.edtspraying)
        editlabspraying = findViewById(R.id.edtlabspraying)
        editcherrypick = findViewById(R.id.edtcherrypick)
        editlabcherrypick = findViewById(R.id.edtlabcherrypick)
        edittransport = findViewById(R.id.edttransport)
        editlabtransport = findViewById(R.id.edtlabtransport)
        editmilling = findViewById(R.id.edtmilling)
        editlabmilling = findViewById(R.id.edtlabmilling)
        editdrying = findViewById(R.id.edtdrying)
        editlabdrying = findViewById(R.id.edtlabdrying)
        editsorting = findViewById(R.id.edtsorting)
        editlabsorting = findViewById(R.id.edtlabsorting)
        submitbutton = findViewById(R.id.btnsubmitdata)
        instruction_id = findViewById(R.id.instruct_id)

        var instructionview = "Check the box if activity is done"
        var SpannableString = SpannableString(instructionview)
        SpannableString.setSpan(UnderlineSpan(),0,SpannableString.length, 0)
        instruction_id.text = SpannableString
        // Receive block name passed from MainActivity
        val receivedBlockName = intent.getStringExtra("BLOCK_NAME")
        if (!receivedBlockName.isNullOrEmpty()) {
            blockname.setText(receivedBlockName)
        }

        startdate.setOnClickListener{
            showDatePickerDialog()
        }



        submitbutton.setOnClickListener{
            var blockname = blockname.text.toString().trim()
            var stdate = startdate.text.toString().trim()
            var acre = "${acreage.text} acres of land"
            var bushesnum = "${numbushes.text} coffee bushes"
            var orgmanure = if (editorgmanure.isChecked)
                "Organic manure done" else "Organic manure not done"
            var laborgmanure = "ksh ${editlaborgmanure.text}"
            var norgmanure = if (editnorgmanure.isChecked)
                "Non-organic manure done" else "Non-organic manure not done"
            var labnorgmanure = "ksh ${editlabnorgmanure.text}"
            var weeding = if (editweeding.isChecked)
                "Weeding done" else "Weeding not done"
            var labweeding = "ksh ${editlabweeding.text}"
            var pruning = if (editpruning.isChecked)
                "Pruning done" else "Pruning not done"
            var labpruning = "ksh ${editlabpruning.text}"
            var spraying = if (editspraying.isChecked)
                "Spraying done" else "Spraying not done"
            var labspraying = "ksh ${editlabspraying.text}"
            var cherrypicking = if (editcherrypick.isChecked)
                "Cherry picking done" else "Cherry picking not done"
            var labcherrypicking = "ksh ${editlabcherrypick.text}"
            var transport = if (edittransport.isChecked)
                "Transport to factory done" else "Transport to factory"
            var labtransport = "ksh ${editlabtransport.text}"
            var milling = if (editmilling.isChecked)
                "Milling done" else "Milling not done"
            var labmilling = "ksh ${editlabmilling.text}"
            var drying = if (editdrying.isChecked)
                "Drying done" else "Drying not done"
            var labdrying = "ksh ${editlabdrying.text}"
            var sorting = if (editsorting.isChecked)
                "Sorting done" else "Sorting not done"
            var labsorting = "ksh ${editlabsorting.text}"

            var timeid = System.currentTimeMillis().toString()

            // progress bar
            var progress = ProgressDialog(this)
            progress.setTitle("Saving data")
            progress.setMessage("Please wait!")

            // validation
            if (blockname.isEmpty() || stdate.isEmpty() || acre.isEmpty() || bushesnum.isEmpty() ||
                orgmanure.isEmpty() || laborgmanure.isEmpty() || //norgmanure.isEmpty() ||
                weeding.isEmpty() || labweeding.isEmpty() ||
                pruning.isEmpty() || labpruning.isEmpty() || labpruning.isEmpty() ||
                spraying.isEmpty() || labspraying.isEmpty() || cherrypicking.isEmpty() ||
                labcherrypicking.isEmpty() || transport.isEmpty() || labtransport.isEmpty()
                || milling.isEmpty() || labmilling.isEmpty() || drying.isEmpty() ||
                labdrying.isEmpty() || sorting.isEmpty() || labsorting.isEmpty())
            {

                Toast.makeText(this, "Cannot submit empty fields!", Toast.LENGTH_SHORT).show()

            } else{

                var mychild = FirebaseDatabase.getInstance().reference.child("Data/" + timeid)
                val currentUser = FirebaseAuth.getInstance().currentUser
                val uid = currentUser?.uid

                if (uid != null) {
                    val mychild = FirebaseDatabase.getInstance().reference
                        .child("Data")
                        .child(uid)
                        .child(timeid)

                    val blockdata = Block(
                        blockname, stdate, acre, bushesnum, orgmanure, laborgmanure,
                        norgmanure, labnorgmanure, weeding, labweeding, pruning, labpruning,
                        spraying, labspraying, cherrypicking, labcherrypicking,
                        transport, labtransport, milling, labmilling,
                        drying, labdrying, sorting, labsorting, timeid
                    )

                    progress.show()

                    mychild.setValue(blockdata).addOnCompleteListener {
                        progress.dismiss()
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Data uploaded successfully!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Failed to upload data!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "User not logged in!", Toast.LENGTH_SHORT).show()
                }


               //var blockdata = Block( blockname,stdate,acre,bushesnum,orgmanure,laborgmanure,
                 //   norgmanure,labnorgmanure,weeding,labweeding,pruning,labpruning,spraying,
                   // labspraying,cherrypicking,labcherrypicking,transport,labtransport,milling,
                    // labmilling,drying,labdrying,sorting ,labsorting ,timeid)

                // progress
                //progress.show()

                //mychild.setValue(blockdata).addOnCompleteListener {
                  //  if (it.isSuccessful){
                      //  Toast.makeText(this, "Data uploaded successfully!", Toast.LENGTH_SHORT).show()
                    //} else{
                      //  Toast.makeText(this, "Failed to upload data!", Toast.LENGTH_SHORT).show()
                    }

                }




            }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Handle the selected date
                val selectedDateCalendar = Calendar.getInstance()
                selectedDateCalendar.set(selectedYear, selectedMonth, selectedDay)

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) // You can change the date format
                val formattedDate = dateFormat.format(selectedDateCalendar.time)

                startdate.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

        }





