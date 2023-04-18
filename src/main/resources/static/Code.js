//lager et objekt av all dataen fra inputfeltene
function kjopBillet() {
    let Billett = {
        film : $("#Film").val(),
        antall : $("#Antall").val(),
        forNavn : $("#Fornavn").val(),
        etterNavn : $("#Etternavn").val(),
        nummer : $("#Nummer").val(),
        epost : $("#Epost").val()
    };
    //her starter alle if setningene for å sjekke alle inputfeltene
    let bol = true; //en verdi for å sjekke med if setningene under
    if ($("#Film").val() == ""){
        $("#FiError").html("Du må velge en film!")
        bol = false;
    }else {
        $("#FiError").html("")
    }
    if ($("#Antall").val() == ""){
        $("#AError").html("Du må skrive inn et antall!");
        bol = false;
    }else {
        $("#AError").html("")
    }

    if ($("#Fornavn").val() == ""){
        $("#FError").html("Du må skrive inn et fornavnet!");
        bol = false;
    }else {
        $("#FError").html("")
    }

    if ($("#Etternavn").val() == ""){
        $("#EError").html("Du må skrive inn et etternavn!");
        bol = false;
    }else {
        $("#EError").html("")
    }

    if ($("#Nummer").val() == ""){
        $("#TError").html("Du må skrive inn et nummer!");
        bol = false;
    }else {
        $("#TError").html("")
    }

    if ($("#Epost").val() == ""){
        $("#EPError").html("Du må skrive inn en E-post!");
        bol = false;
    }else {
        $("#EPError").html("")
    }

    //om "bol" = true så sender den all informasjonen til BilletController via PostMapping hvor det blir lagt inn i et array og starter funksjonen "hentAlle"
    if (bol){
        $.post("/lagre", Billett, function(){
            console.log(Billett);
            hentAlle();
        }); //Tømmer input-feltene om "bol" = true
        $("#Film").val("");
        $("#Antall").val("");
        $("#Fornavn").val("");
        $("#Etternavn").val("");
        $("#Nummer").val("");
        $("#Epost").val("");
    }
}
//her henter den all dataen lagret i arrayet via GetMapping og sender det videre til funksjonen "formaterData"
function hentAlle() {
    $.get("/hentAlle", function(data) {
        formaterData(data);
        console.log("console test: "+data);
    });
}
//her former vi en "ut" setning som da blir tabellen når denne funksjonen går
function formaterData(billett){
    console.log("Før løkke i formaterData "+billett);
    let ut = "<table style='background-color: white' class=\"table table-bordered\"><tr>" +
        "<th>Film </th><th> Antall </th><th> Fornavn </th><th> Etternavn </th><th> Nummer </th><th> Epost</th>" +
        "</tr>";
    for(let i of billett ){ //her er det en for løkke som skriver ut alle objektene i et array
        ut += "<tr>";
        ut += "<td>" + i.film + "</td><td>" + i.antall +"</td><td>" + i.forNavn + "</td><td>"
            + i.etterNavn + "</td><td>" + i.nummer + "</td><td>" + i.epost + "</td>";
        ut += "</tr>";
        console.log("Film i formaterData: "+i.film);
    }
    ut += "</table>";
    $("#BilletVisning").html(ut);
}
function slettBillet() { //dette er bare en lett funskjon som sletter alt inni arrayet via "/slettAlle" GetMapping i controlleren
    $.get( "/slettAlle", function() {
        hentAlle();
    });
}