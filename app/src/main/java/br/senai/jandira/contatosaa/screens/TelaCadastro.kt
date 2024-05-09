package br.senai.jandira.contatosaa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.jandira.contatosaa.R
import br.senai.jandira.contatosaa.model.Contato
import br.senai.jandira.contatosaa.repository.ContatoRepository

@Composable
fun TelaCadastro() {

    val cr = ContatoRepository(LocalContext.current)

    var nomeState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var dataNascimentoState = remember {
        mutableStateOf("")
    }
    var amigoState = remember {
        mutableStateOf(false)
    }
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF7821F3)
    ){
        Card (
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Card(
                        modifier = Modifier.size(width = 32.dp, height = 32.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFBA8EF8))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Seta voltar",
                                tint = Color.Black
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.size(width = 160.dp, height = 140.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Card (
                            modifier = Modifier
                                .size(130.dp, 130.dp)
                                .align(alignment = Alignment.Center),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = CircleShape
                        ){
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ){

                            }
                        }
                        Card (
                            modifier = Modifier.size(50.dp,50.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFBA8EF8)),
                            shape = CircleShape

                        ){
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(imageVector = Icons.Default.AddAPhoto,
                                    contentDescription = "Botao foto"
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.size(width = 32.dp, height = 32.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFBA8EF8))
                    ) {
                        Box (
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                imageVector = Icons.Default.QuestionMark,
                                contentDescription = "Pergunta",
                                tint = Color.Black
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(value = nomeState.value,
                    onValueChange = {nomeState.value = it
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_name))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription ="pessoa" )
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(value = phoneState.value,
                    onValueChange = {
                                    phoneState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_phone))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Phone, contentDescription ="phone" )
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(value = emailState.value,
                    onValueChange = {
                                    emailState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_email))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription ="email" )
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(value = dataNascimentoState.value,
                    onValueChange = {
                                    dataNascimentoState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_birthday))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.CalendarMonth, contentDescription ="aniversario" )
                    }
                )
                Row (
                    modifier = Modifier.padding(horizontal = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(checked = amigoState.value,
                        onCheckedChange ={
                            amigoState.value = it
                        }
                    )
                    Text(text = stringResource(id = R.string.contact_friend))
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button( modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 32.dp),
                    onClick = {
                              val contato = Contato(
                                  nome = nomeState.value,
                                  telefone = phoneState.value,
                                  email = emailState.value,
                                  dataNascimento = dataNascimentoState.value,
                                  isAmigo = amigoState.value
                              )
                        cr.salvar(contato)
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(id = R.string.save_contact))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TelaCadastroPreview() {
    TelaCadastro()
}