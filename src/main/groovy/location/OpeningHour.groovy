package location

class OpeningHour {
    Integer dayOfWeek
    String from1
    String to1


    @Override
    String toString() {
        return dayOfWeek + "|" + from1 + "|" + to1
    }
}
