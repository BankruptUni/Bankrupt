package com.example.bankruptuni.api

open class GetRetorno(ok:Boolean, mensagem:String)
open class PostRetorno(ok:Boolean, mensagem:String)
data class GetRetornoObj<T>(val ok:Boolean, val mensagem:String, val objeto: T) :
    GetRetorno(ok,mensagem)

data class PostRetornoObj<T>(val ok:Boolean, val mensagem:String, val objeto: T) : PostRetorno(ok,mensagem)