# Nome: Fabricio Candido
# Disciplina: Programação de Sistemas
# Aula: 03_Estrturas
# Data: 15/03/2026
#
# Descrição: Fazer um programa de uma bibliote que cadastre pelo menos 3 livros durante o uso, ela tem que registrar emprestimos, devoluções e gerar um relatorio final

# Abrir a lista
catalogo = [
    {"titulo": "Codigo Limpo", "autor": "Robert C. Martin", "ano": 2008, "disponivel": True},
    {"titulo": "Entendendo Algoritmos", "autor": "Aditya Bhargava", "ano": 2016, "disponivel": True},
    {"titulo": "Python Fluente", "autor": "Luciano Ramalho", "ano": 2015, "disponivel": False}

]

print("===> Catalogo da Biblioteca <====\n")

# Usado para percorrer os livros
for livro in catalogo:

# Verificar se esta disponivel o nn
    if livro["disponivel"]: 
        status = "Disponivel"
    else:
        status = "Emprestado"
    

# Mostra as informações do livro
    print(f'{livro["titulo"]} ({livro["ano"]})')
    print(f'Autor: {livro["autor"]} | Status: {status}')
    print("-" * 30)
#Pedir novo livro

print("\nCdastrar novo livro")
# Entrada de dados

titulo = input("Títulos: ")
autor = input("Autor: ")
ano = int(input("Ano:"))

novo_livro = {
    "titulo": titulo,
    "autor": autor,
    "ano": ano,
    "disponivel": True
}

catalogo.append(novo_livro)

print("\n=== Catálogo atualizado ===\n")

for livro in catalogo:
    if livro["disponivel"]:
        status = "Disponível"
    else:
        status = "Emprestado"

    print(f'{livro["titulo"]} ({livro["ano"]})')
    print(f'Autor: {livro["autor"]} | Status: {status}')
    print("-" * 30)





        
