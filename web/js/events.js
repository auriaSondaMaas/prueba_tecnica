
function eliminar(id) {
    swal({
        title: "¿Está seguro?",
        text: "Una vez eliminado, no será capaz de recuperar la información",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
              url:"Controller?menu=4&opcion=delete&id="+id
          });
          swal("!Poof! !El usuario ha sido eliminado!", {
            icon: "success",
          }).then((ok)=>{
              if(ok) {
                  location.href="Controller?menu=4&opcion=listar";
              }
          });
        } else {
          swal("Se ha cancelado la operación");
        }
    });
}

function imprimir(id) {
    swal({
        title: "¿Desea guardar el archivo?",
        text: "",
        icon: "info",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
              url:"Controller?menu=1&opcion=print&id="+id
          });
          swal("¡El archivo se ha descargado con éxito!", {
            icon: "success",
          }).then((ok)=>{
              if(ok) {
                  location.href="Controller?menu=1&opcion=listar";
              }
          });
        } else {
          swal("Se ha cancelado la operación");
        }
    });
}


