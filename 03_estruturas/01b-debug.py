# 01b-debug
# Nome: Fabricio Candido
# Data: 15/03/2026
# Desafio : Ache 4 erros no codigo, e depois arrumar 
catalogo = [
    {"titulo":  "Codigo Limpo",         "autor": " Robert C. Martin", "disponivel": True},
    {"titulo": "Etendo Algoritimos", "autor": "Aditya Bhargava", "disponivel": False},
    {"titulo": "Python Fluente", "autor": "Luciano Ramalho", "disponivel": True},



]
# 1. catalogo 3 é inexistente vai até 2 
print ("Primeiro Livro:", catalogo[0]["titulo"])
print ("\nLivros disponiveis:")
for livro in catalogo:
#2. nome da chave, e nn é False é true 

    if livro["disponivel"]==True:
        print(f' {livro["titulo"]}')

total = len(catalogo)
print(f"\nTotal de livros: {total}")
# 3. precisa de um item() para pegar a chave e o valor
for chave, valor in catalogo[0].items():
    print(f" {chave}: {valor}")
# 4. letra minuscula na chave 
primeiro_autor = catalogo[0] ["autor"]
print ("\nAutor do primeiro livro:", primeiro_autor)