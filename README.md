La app esta destinada a buscar personajes de la serie animada rick y morty, para esta app se utilizaron los recursos expuestos en la siguiente pagina https://rickandmortyapi.com/.

se cuentan en la logica con los siguientes package: activities, adapters, data y utils

-------------- Package Activities---------MainActivities-----------------------------------------------
en el package de activites se encuentra el MainActivities el cual cuenta con las principales funciones. La funcion searchByName donde se ejecuta una courutina, la funcion navigateToDetail donde se utiliza el id de los personajes 
para ir a los detalles de cada de ellos, la funcion  initSearchView para el buscador. 
Las variables 
lateinit var binding: ActivityMainBinding ;para visualizar la vista del activities\
lateinit var adapter: CharactersAdapter ;para obtener los datos del adaptader 
lateinit var charactrsList: List<ResultCharacters>; donde se pueden recibir los datos de la data class que almacena todo los items de cada personaje. 
 
  ----------Package Activities---------------Detail----------------------------

En el activitie llamado Detail podemos encontrar la logica para ejecutar los detalles de cada personaje
se encuentra la funcion getRetrofit para ejecutar la parte estatica de la api; 
La funcion getById para obtener datos de personaje por cada id.
la funcion LoadData se encarga de cargar los detalles de cada personaje y dibujar el layout.

----- Package adapters----------CharactersAdapter-------------------------
En esta clase se tiene la logica empleada para visualizar los datos con el recyclerview en la pagina principal de la app.
Funcion onCreateViewHolder se encarga de crear la vista 
Funcion onBindViewHolder para actualizar las vistas
Funcion getItemCount para saber la cantidad de elementos 
Funcion CharacteresViewHolder para pintar los elementos del recycler\


------Package data---------CharacterDataResponsive ------------------
aca se tiene la clase ResultCharacters donde se cargan los parametros que se utilizaran para obtener la lista de personajes en el results



------Package data-------- -------RetrofitService

aca se tiene la interface RetrofitService la cual cuenta con los query y path para interactuar con el link de la api y obtener los datos 

--------------- Package utils -------  Constants 
en la Constants se almacena la aprte estatica o base de la url de la api.

----------Package utils ----- RetrofitProvider 
parte donde esta la funcion que almacena la logica del Retrofit para proveer a otros activities.

--------UserActivities
funcion saveData para guardar los datos mediante sharedpreferences 
funcion cancelData para eliminar los datos de del sharedpreferences 
funcion infoData la cual nos muestra mediante un AlertDialog los datos alamacenaos del sharedpreferences 


