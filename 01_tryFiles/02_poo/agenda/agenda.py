"""
agenda.py - Aula 23 (Programação de Sistemas, 2026)
Agenda de Contatos com menu interativo e persistência(.txt e binario)

"""

import pickle

class Contato:
    """Representa um contato de agenda"""

def __init__(self, nome, telefone, email):
    self.nome = nome
    self.teleone = telefone
    self.email = email
def exibir(self):
    print(f" Nome : {self.nome}")
    print(f" Telefone : {self.telefone}")
    print(f" Email : {self.email}")
def para_linha_txt(self):
    return f"{self.nome}; {self.telefone}; {self.email}"
def salvar_em_txt(contatos, caminho):
    with open(caminho, "w", encoding="utf-8") as arquivo:
        for c in contatos:
            arquivo.write(c.para_linha_txt() + "\n")
            print("✔️ {len(contatos)} contato(s) salvo(s) em {caminho}")

def carregar_de_txt(caminho):
    contatos = []
    try:
        with open(caminho, "r", encoding="utf-8") as arquivos:
            for linha in arquivos:
                linha = linha.strip()
                if not linha:
                    continue
                partes = linha.split(";")
                nome, telefone, email = partes[0], partes[1], partes[2]
                contatos.append(Contato(nome, telefone, email))
    except FileExistsError:
        print(f"Arquivo {caminho} ainda não existente. Começando vazio.")
    return contatos

def salvar_em_binario(contatos, caminho):
    try:
        with open(caminho, "rb") as arquivo:
            return pickle.load(arquivo)
    except FileNotFoundError:
        print(f"Arquivo {caminho} ainda não existe. Começando vazio.")
        return[]
    

def cadastrar(contatos):
    print("\n - - - Novo Contrato - - -")
    nome = input("Nome   : ")
    telefone = input("Telefone: ")
    email = input("Email  : ")

    contatos.append(Contato(nome, telefone, email))
    print(" ✔️ Contato cadastrado")
def listar(contatos):
    if not contatos:
        print("\n(agenda vazia)")
        return
    print(f"\n - - - Agenda ({len(contatos)} contatos) - - -")
    for i, c in enumerate(contatos, start=1):
        print(f"\n[{i}]")

        c.exibir()



def remover(contatos):
    listar(contatos)
    if not contatos:
        return
    indice = int(input("\nN Do contato a remover")) - 1
    if 0 <= indice  < len(contatos):
        removido = contatos.pop(indice)
        print(f"✔️ Contato '{removido.nome}'removido.")
    else:
        print("Indice Invalido")

def menu():
    contatos = carregar_de_binario("agenda.bin")

    while True:
        print("\n===== Agenda =====")
        print("1 - Cadastrar  contato")
        print("2 - Listarcontatos" \
        ")