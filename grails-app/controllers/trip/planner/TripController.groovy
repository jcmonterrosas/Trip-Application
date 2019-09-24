package trip.planner

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TripController {

    TripService tripService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tripService.list(params), model:[tripCount: tripService.count()]
    }

    def show(Long id) {
        respond tripService.get(id)
    }

    def create() {
        respond new Trip(params)
    }

    def save(Trip trip) {
        if (trip == null) {
            notFound()
            return
        }

        try {
            tripService.save(trip)
        } catch (ValidationException e) {
            respond trip.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trip.label', default: 'Trip'), trip.id])
                redirect trip
            }
            '*' { respond trip, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tripService.get(id)
    }

    def update(Trip trip) {
        if (trip == null) {
            notFound()
            return
        }

        try {
            tripService.save(trip)
        } catch (ValidationException e) {
            respond trip.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trip.label', default: 'Trip'), trip.id])
                redirect trip
            }
            '*'{ respond trip, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tripService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'trip.label', default: 'Trip'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trip.label', default: 'Trip'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
