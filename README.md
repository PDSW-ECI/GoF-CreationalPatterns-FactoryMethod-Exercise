## Escuela Colombiana de Ingeniería

### Procesos de Desarrollo de Software 

## Laboratorio - Patrones Creacionales, Principios SOLID


## Parte I.

Revise el proyecto disponible en:

https://github.com/PDSW-ECI/GoF-FactoryMethod-ReferenceExample

Haga una copia local con el comando

```java
git clone https://github.com/PDSW-ECI/GoF-FactoryMethod-ReferenceExample
```


## Parte II.

En este repositorio se encuentra una versión muy rudimentaria del editor de texto *Guord for dummies*. Este editor de texto, como su nombre lo indica, está orientado a personas inexpertas en el uso de tecnología, y cuenta como principal elemento el no requerir interactuar con un sistema de archivos (todos los documentos se guardan en una ruta estándar). Por ahora, sólo soporta el inglés.

Actualmente la aplicación hace uso del API de serialización de Java para hacer persistentes y reconstruir los documentos (en una ruta estándar desconocida por el usuario), y de la clase File para obtener el listado de los documentos creados en la misma (para cuando el usuario solicite abrir uno de los archivos).

Cuando el usuario tiene listo su documento, y al seleccionar la opción de guardar, la aplicación sólo le pregunta el nombre del documento, mas no en qué ruta lo guardará. La aplicación se encarga de mantener oculto este detalle, y simplemente, cuando el usuario selecciona la opción de ‘abrir’, ésta le muestra el listado de documentos previamente guardados.

Como todo buen editor de texto, esta herramienta busca integrar algunos recursos léxicos para asistir en la auto-corrección de errores tipográficos u ortográficos. Por ahora, la aplicación hace uso de la clase TypoCorrector, la cual contiene un conjunto local (integrado en la herramienta) de equivalencias de palabras.

El modelo de clases de la aplicación, por lo tanto, por ahora se reduce a:

![](./img/media/image9.png)

__Ejercicio.__

Se le ha pedido que revise la aplicación y haga con la misma un ejericicio de ‘refactoring’, ya que ésta claramente no considera una arquitectura por capas, lo que dificultará en el futuro el mantenimiento de la misma. En particular se le ha pedido. 

* Rediseñar la aplicación de manera que en la misma se puedan identificar claramente capas de presentación, lógica y persistencia. Utilice las [convenciones de Java para el nombramiento de paquetes](http://www.oracle.com/technetwork/java/codeconventions-135099.html) para que las clases correspondientes a cada capa queden en paquetes separados.

* Hacer los ajustes que hagan falta para que, además del mecanismo de persistencia mediante serialización, sea fácil incorporar nuevos mecanismos (en caso de que la serialización resulte obsoleta o ineficiente). Por ahora, se quere incorporar un esquema alternativo de persistencia basado en el almacenamiento del documento como texto plano.

* Hacer los ajustes que hagan falta para hacer fácil la adaptación de nuevos mecanismos de corrección automática de errores tipográficos/ortográficos. Por ahora se espera que se pueda elegir entre el existente (que hace uso de datos estáticos), y uno alternativo que haga uso de una base de datos -en línea- de errores tipográficos (los cuales son contínuamente actualizados): http://190.24.150.86/hcadavid/lang/eng_misspellings.txt
	
Con lo anterior, se quiere que la aplicación permita:

1. Agregarle mecanismos alternativos de persistencia de archivos SIN necesidad de modificar el _CORE_ de la aplicación.

2. Agregarle estrategias alternativas alternativas para la corrección de errores tipográficos SIN necesidad de modificar el _CORE_ de la aplicación.

### Proceso sugerido:

1. Proponga un nuevo diseño para la aplicación, donde se tengan clases que encapsulen las operaciones de la aplicación sujetas a eventuales cambios.
2. Con lo anterior, considere el patrón [Método Fábrica](https://dzone.com/articles/design-patterns-factory), para una segunda versión del diseño. Tip: los productos concretos serán las clases identificadas en el paso 1.

3. Usando como referencia [el proyecto indicado inicialmente](https://github.com/PDSW-ECI/GoF-FactoryMethod-ReferenceExample), haga la implementación del diseño planteado.


## Criterios de evaluación

1. Funcionalidad. La aplicación debe poderse configurar para
	* Usar un formato basado en cadenas serializadas, o uno basado en texto plano.

2. La solución debe quedar abierta para extensión y cerrada para modificación. Es decir, debe permitir (sólo configurando las fábricas):
	* Agregar nuevos esquemas de persistencia.
	* Agregar nuevas estrategias de corrección automática.
	
