abstract class Report {
    void runReport() {
        // set up report
    }

    void printReport() {
        // generic printing
    }
}

class BuzzwordsReport extends Report {
    void runReport() {
        super.runReport();
        buzzwordCompliance();
        printReport();
    }

    void buzzwordCompliance() {...}
}
