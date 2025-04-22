package com.example.ranjecoffeemanagement

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth


class DataInputActivity : AppCompatActivity(){
    lateinit var blockname:EditText
    lateinit var startdate:EditText
    lateinit var acreage:EditText
    lateinit var numbushes:EditText
    lateinit var editorgmanure:EditText
    lateinit var editlaborgmanure:EditText
    lateinit var editnorgmanure:EditText
    lateinit var editlabnorgmanure:EditText
    lateinit var editweeding:EditText
    lateinit var editlabweeding:EditText
    lateinit var editpruning:EditText
    lateinit var editlabpruning:EditText
    lateinit var editspraying:EditText
    lateinit var editlabspraying:EditText
    lateinit var editcherrypick:EditText
    lateinit var editlabcherrypick:EditText
    lateinit var edittransport:EditText
    lateinit var editlabtransport:EditText
    lateinit var editmilling:EditText
    lateinit var editlabmilling:EditText
    lateinit var editdrying:EditText
    lateinit var editlabdrying:EditText
    lateinit var editsorting:EditText
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

        var instructionview = "Instruction: Type Yes/No"
        var SpannableString = SpannableString(instructionview)
        SpannableString.setSpan(UnderlineSpan(),0,SpannableString.length, 0)
        instruction_id.text = SpannableString
        // Receive block name passed from MainActivity
        val receivedBlockName = intent.getStringExtra("BLOCK_NAME")
        if (!receivedBlockName.isNullOrEmpty()) {
            blockname.setText(receivedBlockName)
        }


        submitbutton.setOnClickListener{
            var blockname = blockname.text.toString().trim()
            var stdate = startdate.text.toString().trim()
            var acre = acreage.text.toString().trim()
            var bushesnum = numbushes.text.toString().trim()
            var orgmanure = editorgmanure.text.toString().trim()
            var laborgmanure = editlaborgmanure.text.toString().trim()
            var norgmanure = editnorgmanure.text.toString().trim()
            var labnorgmanure = editlabnorgmanure.text.toString().trim()
            var weeding = editweeding.text.toString().trim()
            var labweeding = editlabweeding.text.toString().trim()
            var pruning = editpruning.text.toString().trim()
            var labpruning = editlabpruning.text.toString().trim()
            var spraying = editspraying.text.toString().trim()
            var labspraying = editlabspraying.text.toString().trim()
            var cherrypicking = editcherrypick.text.toString().trim()
            var labcherrypicking = editlabcherrypick.text.toString().trim()
            var transport = edittransport.text.toString().trim()
            var labtransport = editlabtransport.text.toString().trim()
            var milling = editmilling.text.toString().trim()
            var labmilling = editlabmilling.text.toString().trim()
            var drying = editdrying.text.toString().trim()
            var labdrying = editlabdrying.text.toString().trim()
            var sorting = editsorting.text.toString().trim()
            var labsorting = editlabsorting.text.toString().trim()

            var timeid = System.currentTimeMillis().toString()

            // progress bar
            var progress = ProgressDialog(this)
            progress.setTitle("Saving data")
            progress.setMessage("Please wait!")

            // validation
            if (blockname.isEmpty() || stdate.isEmpty() || acre.isEmpty() || bushesnum.isEmpty() ||
                orgmanure.isEmpty() || laborgmanure.isEmpty() || norgmanure.isEmpty() ||
                labnorgmanure.isEmpty() || weeding.isEmpty() || labweeding.isEmpty() ||
                pruning.isEmpty() || labpruning.isEmpty() || labpruning.isEmpty() ||
                spraying.isEmpty() || labspraying.isEmpty() || cherrypicking.isEmpty() ||
                labcherrypicking.isEmpty() || transport.isEmpty() || labtransport.isEmpty()
                || milling.isEmpty() || labmilling.isEmpty() || drying.isEmpty() ||
                labdrying.isEmpty() || sorting.isEmpty() || labsorting.isEmpty()){

                Toast.makeText(this, "Cannot submit empty fields!", Toast.LENGTH_SHORT).show()

            } else{

                //var mychild = FirebaseDatabase.getInstance().reference.child("Data/" + timeid)
                val currentUser = FirebaseAuth.getInstance().currentUser
                val uid = currentUser?.uid

                if (uid != null) {
                    val mychild = FirebaseDatabase.getInstance().reference
                        .child("Data")
                        .child(uid)
                        .child(timeid)

                    val blockdata = Block( /* ... keep your data */ )

                    progress.show()

                    mychild.setValue(blockdata).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, "Data uploaded successfully!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Failed to upload data!", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "User not logged in!", Toast.LENGTH_SHORT).show()
                }


                var blockdata = Block( blockname,stdate,acre,bushesnum,orgmanure,laborgmanure,
                    norgmanure,labnorgmanure,weeding,labweeding,pruning,labpruning,spraying,
                    labspraying,cherrypicking,labcherrypicking,transport,labtransport,milling,
                    labmilling,drying,labdrying,sorting ,labsorting ,timeid)

                // progress
                //progress.show()

                //mychild.setValue(blockdata).addOnCompleteListener {
                  //  if (it.isSuccessful){
                        Toast.makeText(this, "Data uploaded successfully!", Toast.LENGTH_SHORT).show()
                    //} else{
                      //  Toast.makeText(this, "Failed to upload data!", Toast.LENGTH_SHORT).show()
                    }

                }




            }

        }





