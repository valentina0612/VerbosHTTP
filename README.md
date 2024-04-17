#Verbos HTTP
En el protocolo de transferencia de hipertexto (HTTP), los verbos o métodos son acciones que un cliente puede solicitar a un servidor para realizar una operación específica en un recurso.
A continuación, se explican los verbos HTTP más comunes:

##•	GET
Este método se utiliza para recuperar o consultar información desde un recurso. Este método no produce ningún efecto secundario en el servidor, es por ello por lo que se dice que el método GET es idempotente, es decir, sin importar cuantas veces se ejecute, el resultado será el mismo.

![Captura de pantalla 2024-04-16 185317](https://github.com/valentina0612/VerbosHTTP/assets/126031586/81442646-6ebc-4d0d-9eb5-86745c19d4da)

##•	POST
Este método envía datos al servidor, y se utiliza para crear un nuevo recurso. Este método no es idempotente, ya que cada ejecución de este deberá producir un nuevo recurso.

 ![Captura de pantalla 2024-04-16 185440](https://github.com/valentina0612/VerbosHTTP/assets/126031586/94acdb02-bbac-4c58-b6fa-5068b62a12ca)

##•	PUT
Este método se utiliza para actualizar un recurso existente en el servidor, de forma tal que reemplaza por completo el contenido existente por los datos proporcionados en la petición.
![Captura de pantalla 2024-04-16 185648](https://github.com/valentina0612/VerbosHTTP/assets/126031586/a9cb354b-79f6-4a90-9c4a-80d0d5fab153)

##•	PATCH
Este método se utiliza para actualizar un recurso existente en el servidor, pero a diferencia de PUT, este solo reemplaza algunos elementos del recurso existente por los proporcionados en la petición.
![Captura de pantalla 2024-04-16 185741](https://github.com/valentina0612/VerbosHTTP/assets/126031586/79dd0c4e-643d-46c4-b050-135c94ce2bae)

##•	DELETE
Este método se utiliza para eliminar un recurso en el servidor.
 ![Captura de pantalla 2024-04-16 191101](https://github.com/valentina0612/VerbosHTTP/assets/126031586/cfc06a05-af67-4817-aad2-547951955e86)

##•	HEAD
Se utiliza para obtener información sobre un recurso sin descargar el contenido completo. Una respuesta HEAD debe contener todos los encabezados que se habrían enviado en una respuesta GET correspondiente, pero el cuerpo del mensaje de respuesta debe estar vacío
![Captura de pantalla 2024-04-16 185912](https://github.com/valentina0612/VerbosHTTP/assets/126031586/7adc73c3-0c9b-4575-b927-af53304dbb2e)

##•	OPTIONS
Este método se utiliza para obtener información sobre los métodos HTTP que admite un recurso. Los navegadores envían una solicitud de OPTIONS HTTP para conocer los métodos HTTP admitidos y otras opciones admitidas para el recurso de destino antes de enviar la solicitud real.
 ![Captura de pantalla 2024-04-16 190629](https://github.com/valentina0612/VerbosHTTP/assets/126031586/3aa69c40-11fe-40e1-a326-f9e2e2c1bc16)

