package trip.planner

class Trip {

    String destino
    String espectativas
    String actividades
    Integer cantidadDias
    Date diaInicio
    Date diaFin   

    static constraints = {
        destino blank: false
        cantidadDias blank: false
        diaInicio nullable: true
        diaFin nullable: true
        actividades widget: 'textarea'
        espectativas nullable: true, widget: 'textarea'
    }
}
