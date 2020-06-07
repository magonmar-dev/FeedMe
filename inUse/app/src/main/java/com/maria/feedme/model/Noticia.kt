package com.maria.feedme.model

class Noticia (
    var titulo: String,
    var fechaPub: String,
    var link: String,
    var autor: String,
    var miniatura: String,
    var imagen: String,
    var contenido: String
) {
    constructor() : this("", "", "",
        "", "", "", "")
}