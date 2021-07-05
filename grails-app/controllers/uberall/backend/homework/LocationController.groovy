package uberall.backend.homework

import grails.converters.JSON
import grails.converters.XML
import grails.rest.RestfulController
import groovy.transform.CompileStatic
import location.Location
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

@CompileStatic
class LocationController extends RestfulController<Location> {
    static responseFormats = ['json', 'csv', 'xml', 'text']
    LocationService locationService

    LocationController() {
        super(Location)
    }

    def index(Integer max, String format) {
        if (max == null)
            max = 10;
        if(format == null)
            format = "json"
        List<Location> locations = locationService.findAll(max)
        switch (format) {
            case "xml":
                render locations as XML
                break
            case "csv":
                String result = locationService.renderToCsv(locations)
                render(contentType:'text/csv',text:result)
                break
            case "json":
                render locations as JSON
                break
            default: respond locations as JSON
        }
    }
}
