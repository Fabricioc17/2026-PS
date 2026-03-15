#==================================
# SISTEMA DE BIBLIOTECA
#==================================
# Disciplina: Programação de Sistemas
# Aula: 05 - Revisao: Estruturas de Dados
# Autor: Fabricio Candido
# Data: 15/03/2026
# Repositorio: https://github.com/Fabricioc17/2026-PS
#==================================
#
# Descrição:
# Catalogo de livros que demonstra o uso de listas
# e dicionarios para armazenar, consuktar é filtrar dados 
#===================================
#==== LISTAS: CONCEITTO BÁSICO ====
# Criando uma lista de titulos
titulos = [
    "O programador pragmatico",
    "Codigo Limpo",
    "Entendendo Algoritimos"


]
# Acesso por indice (começa  em, 0 não em 1!)
print("Primeiro Livro:", titulos[0])
print("Último Livro:", titulos[-1]) # Indice -1 = ultimo elemento
print("Total de livros:", len(titulos))

#=========== MÉTODO DE LISTA ===========
print("\n---Operação na lista ---")
#Adicionar 1 item ao final
titulos.append("Python Fluente")
print("Após append:", titulos)
#Verificar se um item existe 
busca = "Codigo Limpo"
if busca in titulos:
    print (f'"{busca}" está no catálogo.')
else:
    print(f'"{busca}" não encontrado')

# Ordenar a lista
titulos.sort()
print("Lista ordenada:", titulos)

# Remover um item 
titulos.remove("Entendendo Algoritimos")
print("Após remove:", titulos)

#---- DICIONARIOS: CONCEITO BÁSICO ----

# Um diicionario representa um livro com seus atributos
livro = {
    "titulos":     "O Programador Pragmatico",
    "autor":       "Andrew Hunt",
    "ano":         1999,    #int, não string
    "disponivel":  True,    #bool



}
# Acessando valores pelas chaves
print("Títulos :", livro["titulos"])
print("Autor :", livro["autor"])
print("Ano :", livro["ano"])
print("Status :", "Disponivel" if livro["disponivel"] else "Emprestado")

#---- MODIFICANDO E CONSULTANDO -----
#Atualizando um valor existente
livro["disponivel"] = False # livro foi emprestado
print("\nApós emprestimo:", livro["disponivel"])

# Adicionando uma nova chave

livro["paginas"] = 352
print ("Páginas:", livro["paginas"])
#. get () - acesso seguro: retorna mone (ou padrao) se a chave nao existir
editora = livro.get ("editora", "Não informada")
print ("Editora: ", editora) # Nn lança KeyError, retorna o padrão

# ---- CATÁLOGO: LISTA DE DICIONÁRIOS ----

catalogo = [
    {"titulo": "O Programador Pragmático", "autor": "Andrew Hunt", "ano": 1999,
     "disponivel": True},

    {"titulo": "Código Limpo", "autor": "Robert C. Martin", "ano": 2008,
     "disponivel": False},

    {"titulo": "Entendendo Algoritmos", "autor": "Aditya Bhargava", "ano": 2016,
     "disponivel": True},
]

print("=== Catálogo da Biblioteca ===")
print()

# Percorrendo cada livro com for
for livro in catalogo:
    status = "✅ Disponível" if livro["disponivel"] else "📕 Emprestado"

    print(f'  {livro["titulo"]} ({livro["ano"]})')
    print(f'  Autor: {livro["autor"]} | {status}')
    print(" " + "-" * 40)
    # ---- CONSULTAS E FILTROS ----

print("\n=== Livros disponíveis ===")

for livro in catalogo:
    if livro["disponivel"]:        # filtra apenas os disponíveis
        print(f'  ✅ {livro["titulo"]}')


print("\n=== Busca por título ===")

busca = input("Digite o título (ou parte): ").lower()

encontrado = False

for livro in catalogo:
    if busca in livro["titulo"].lower():     # .lower() ignora maiúsculas/minúsculas
        print(f'  Encontrado: {livro["titulo"]} – {livro["autor"]}')
        encontrado = True

if not encontrado:
    print("  Nenhum livro encontrado com esse termo.")


print("\n=== Atributos do primeiro livro ===")

for chave, valor in catalogo[0].items():    # .items() retorna pares (chave, valor)
    print(f"  {chave}: {valor}")