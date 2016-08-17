##Escuela Colombiana de Ingeniería

###Arquitecturas de Software - ARSW

##Taller – Principio de Inversión de dependencias, Contenedores Livianos e Inyección de dependencias.



Entregables:

-   Ejercicio básico, y un avance del ejercicio principal: antes de
    terminar la clase.

-   Nueva versión del diseño: Próximo martes, en clase (impreso).

-   Solución completa: Próximo Jueves, antes del siguiente laboratorio.

Parte I. Ejercicio básico.

1.  Clone el proyecto
    <https://github.com/hectorateci/spring-dependencyinjectionexercise-base.git>
    e impórtelo en Netbeans.

2.  Agregue como dependencia de Maven el artefacto ‘spring-context’:

	-   GROUP-ID:org.spring-framework
	-   ARTIFACT-ID: spring-context
	-   VERSION: 4.2.4-RELEASE

	Nota: Con Netbeans puede usar el asistente de búsqueda del repositorio central de Maven:

	![](./img/media/image1.png)
	![](./img/media/image2.png)
  
3.  Verifique que esta nueva dependencia, junto con sus respectivas
    dependencias, se hayan añadido y descargado:

    ![](./img/media/image3.png)

4.  Cree un nuevo archivo de configuración de Spring. Aunque el nombre
    puede ser cualquiera, por convención este archivo suele
    llamarse ‘applicationContext.xml’. Como se está usando Maven, dicho
    archivo debe ir en la ruta que por convención se usa para los
    archivos de configuración:

    ![](./img/media/image4.png)
    ![](./img/media/image5.png)
    
5.  En este paso se le pedirá indicar qué nombres de
    espacio (namespaces) XML se incluirán en el archivo
    de configuración. Como por ahora sólo se usarán los elementos
    básicos, no es necesario incluir ninguno:

    ![](./img/media/image6.png)

6.  Edite el archivo de configuración de Spring. Primero, defina dos
    beans: uno correspondiente al corrector ortográfico en español, y
    otro al corrector ortográfico en inglés. Para esto, use las opciones
    de autocompletar para los tags (Ctrl+espacio) y para la selección de la clase:

    ![](./img/media/image7.png)

7.  En el mismo archivo agregue un bean correspondiente al
    corrector gramatical. Este bean, a diferencia de los dos anteriores,
    tiene una dependencia a algo de tipo *SpellChecker* llamada
    ‘sc’ (getSc/setSc) que debe ser inyectada, para lo cual se le agrega
    un elemento ‘property’ con el atributo ‘name’ asociado al nombre de
    la propiedad, y con el atributo ‘ref’, que indica qué bean se le
    inyectará a dicha propiedad. Deje la configuración de manera que se
    use el corrector ortográfico para español.

    ![](./img/media/image8.png)

8.  Haga un programa de prueba, donde se cree una instancia de
    GrammarChecker mediante Spring, y se haga uso de la misma.

	```java
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		GrammarChecker gc=ac.getBean(GrammarChecker.class);
		System.out.println(gc.check("la la la "));
	}
	```

9.  Modifique el archivo de configuración de Spring para que el Bean
    ‘spellChecker‘ ahora haga uso de la clase SpanishSpellChecker (para
    que a GrammarChecker se le inyecte *EnglishSpellChecker* en lugar de
    *SpanishSpellChecker*. Verifique el nuevo resultado.

##Parte II.

En este repositorio se encuentra una versión muy rudimentaria del editor de texto *Guord for dummies*. Este editor de texto, como su nombre lo indica, está
orientado a personas inexpertas en el uso de tecnología, y cuenta como
principal elemento el no requerir interactuar con un sistema de
archivos.

Actualmente la aplicación hace uso del API de serialización de Java para
hacer persistentes y reconstruir los documentos (en una ruta estándar
desconocida por el usuario), y de la clase File para obtener el listado
de los documentos creados en la misma (para cuando el usuario solicite
abrir uno de los archivos).

Cuando el usuario ha digitado su texto, y al seleccionar la opción de
guardar, la aplicación sólo le pregunta el nombre del documento, mas no
en qué ruta lo hará. La aplicación se encarga de mantener oculto este
detalle, y simplemente, cuando el usuario selecciona la opción de
‘abrir’, ésta le muestra el listado de documentos previamente guardados.

Como todo buen editor de texto, esta herramienta busca integrar algunos
recursos léxicos para asistir en la auto-corrección de errores
tipográficos u ortográficos. Por ahora, la aplicación hace uso de la
clase TypoSuggestionsEngine, la cual contiene un conjunto estático de
equivalencias de palabras.

El modelo de clases de la aplicación, por lo tanto, por ahora se reduce
a:

![](./img/media/image9.png)

Ejercicio.

Se le ha pedido que revise la aplicación y haga con la misma un
ejericicio de ‘refactoring’, ya que ésta claramente no considera una
arquitectura por capas, lo que dificultará en el futuro el mantenimiento
de la misma. En particular se le ha pedido.

* Ajustar la aplicación para 

* Rediseñar la aplicación de manera que en la misma se puedan identificar claramente capas de presentación, lógica y persistencia. Utilice las [convenciones de Java para el nombramiento de paquetes](http://www.oracle.com/technetwork/java/codeconventions-135099.html) para que las clases correspondientes a cada capa queden en paquetes separados.

* Hacer los ajustes que hagan falta para que, además del mecanismo de persistencia mediante serialización, sea fácil incorporar nuevos mecanismos (en caso de que la serialización resulte obsoleta o ineficiente). Por ahora, se quere incorporar un esquema alternativo de persistencia basado en el almacenamiento del documento como texto plano.

* Hacer los ajustes que hagan falta para hacer fácil la adaptación de nuevos mecanismos de corrección automática de errores tipográficos/ortográficos. Por ahora se espera que se pueda elegir entre el existente (con los datos estáticos), y uno que usted

http://190.24.150.86/hcadavid/lang/eng_misspellings.txt
http://190.24.150.86/hcadavid/lang/spa_misspellings.txt


    debe definir, que hace uso de una base de datos NoSQL de mongoDB,
    accesible en la URL:
    mongodb://test:test@ds031631.mongolab.com:31631/documents . Esta
    base de datos cuenta con una colección llamada ‘commontypos’, que a
    su vez cuenta con un documento con las claves (en los fuentes hay
    disponible un ejemplo):

    -   “words”: la lista de palabras que se consideran válidas.

    -   Una clave por cada palabra errónea comúnmente usada, como
        ‘pocibilidad’ u ‘hoal’(hola).

> Con lo anterior, se quiere que la aplicación pueda funcionar bajo dos
> esquemas:

-   Offline: usando el conjunto de datos ‘estático’.

-   Online: usando las palabras disponibles en la base de datos NoSQL,
    la cual está en permanente actualización.

Por otro lado, para el segundo esquema anterior (online), se quiere
tener dos variantes:

-   Sustitución estándar (sencillamente reemplaza la palabra si la misma
    tiene una ocurrencia en la base de datos).

-   Sustitución verificada (sólo reemplaza si la palabra, además de
    tener una ocurrencia en la base de datos, no existe en la lista
    de palabras).

<!-- -->

-   Se debe tener también en cuenta que parámetros como rutas de
    archivos, URLs y demás, NO deben estar ‘quemadas’ en el código. En
    lugar de esto, las mismas deberían ser inyectadas.

**Nota.**

Este es el conjunto mínimo de datos disponible en la base de datos
MongoDB, para tener en cuenta para las pruebas:

{

"\_id": {

"\$oid": "54c1152403640685ba63d670"

},

"pocibilidad": "posibilidad",

"poxibilidad": "posibilidad",

"hoal": "hola",

"yola": "hola",

"jola": "hola",

"hol": "hola",

"vuenas": "buenas",

"nuenas": "buenas",

"huenas": "buenas",

"pocible": "posible",

"words": \[

"jola,nuenas"

\]

}
