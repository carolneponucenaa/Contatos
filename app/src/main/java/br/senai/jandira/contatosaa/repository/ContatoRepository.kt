package br.senai.jandira.contatosaa.repository

import android.content.Context
import br.senai.jandira.contatosaa.model.Contato
import br.senai.sp.jandira.contatosaa.dao.ContatoDb
import java.security.AccessControlContext

class ContatoRepository (context: Context){
    private val db = ContatoDb.getBancoDeDados(context).contatoDao()

    fun salvar (contato: Contato):Long{
        return db.salvar(contato)
    }

    fun listarTodosOsContatos(): List<Contato>{
        return db.listarTodosOsContatos()
    }
}