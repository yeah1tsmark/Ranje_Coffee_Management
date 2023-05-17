package com.example.ranjecoffeemanagement

class Block {
    var blockname:String = ""
    var stdate:String = ""
    var acre:String = ""
    var bushesnum:String = ""
    var orgmanure:String = ""
    var laborgmanure:String = ""
    var norgmanure:String = ""
    var labnorgmanure:String = ""
    var weeding:String = ""
    var labweeding:String = ""
    var pruning:String = ""
    var labpruning:String = ""
    var spraying:String = ""
    var labspraying:String = ""
    var cherrypicking:String = ""
    var labcherrypicking:String = ""
    var transport:String = ""
    var labtransport:String = ""
    var milling:String = ""
    var labmilling:String = ""
    var drying:String = ""
    var labdrying:String = ""
    var sorting:String = ""
    var labsorting:String = ""
    var timeid :String = ""

    constructor(blockname: String, stdate: String, acre: String, bushesnum: String, orgmanure: String,
        laborgmanure: String, norgmanure: String, labnorgmanure: String, weeding: String,
        labweeding: String, pruning: String, labpruning: String, spraying: String, labspraying: String, cherrypicking: String,
        labcherrypicking: String, transport: String, labtransport: String, milling: String,
        labmilling: String, drying: String, labdrying: String, sorting: String, labsorting: String,
        timeid: String) {
        this.blockname = blockname
        this.stdate = stdate
        this.acre = acre
        this.bushesnum = bushesnum
        this.orgmanure = orgmanure
        this.laborgmanure = laborgmanure
        this.norgmanure = norgmanure
        this.labnorgmanure = labnorgmanure
        this.weeding = weeding
        this.labweeding = labweeding
        this.pruning = pruning
        this.labpruning = labpruning
        this.spraying = spraying
        this.labspraying = labspraying
        this.cherrypicking = cherrypicking
        this.labcherrypicking = labcherrypicking
        this.transport = transport
        this.labtransport = labtransport
        this.milling = milling
        this.labmilling = labmilling
        this.drying = drying
        this.labdrying = labdrying
        this.sorting = sorting
        this.labsorting = labsorting
        this.timeid = timeid
    }

    constructor()
}