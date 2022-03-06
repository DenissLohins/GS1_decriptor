package repository;

import java.util.HashMap;
import java.util.Map;

public class KnownGTINNames {

    private static final Map<String, String> gtinDatabase = new HashMap<>(){{
        put("00000000000017", "ENG CARTON");
        put("08594071470722", "Bortezomib_Heaton_RO_BG");
        put("08594071470685", "Bortezomib_HEATON_CZ_SK");
        put("08594071470791", "Pemetrexed_HEATON_BG");
        put("04751022900033", "Bortezomib_Pharmidea_Latvia");
        put("03859893480034", "Bort_AlphaMedical_HR");
        put("03859893480355", "ZDA_AlphaMedical_HR");
        put("04751022900040", "ZDA_Pharmidea_LV");
        put("05298000530053", "Bortezomib Ledpharm_CY");
        put("08588005823128", "Bortezomib_Pharmevid");
        put("08588005823135", "Pemetrexed_Pharmevid");
        put("03400955031116", "ATOSIBAN STRAGEN 6,75 mg/0,9 ml_FR");
        put("03400955031123", "ATOSIBAN STRAGEN 37,5 mg/5 ml_FR");
        put("04150124050446", "Atosiban Stragen 37,5 mg/5 ml_DE");
        put("04150124050507", "Atosiban Stragen 6,75 mg/0,9 ml_DE");
        put("07046264210611", "Atosiban Stragen 37,5 mg/5 ml_NO_SE_FI");
        put("07046265484813", "Atosiban Stragen 6,75 mg/0,9 ml_NO_SE_FI");
        put("08594171980114", "Atosiban AVMC 0.9 ML");
        put("08594171980121", "Atosiban AVMC 5ML");
        put("05999883507322", "ZOLEDRONSAV PHARMACENTER HU");
        put("04751022900132", "Atosiban_Pharmidea_Latvia");
        put("06285101002892", "BORT HETERO Veelbore_SA");
        put("04779023761347", "Zoledronic Acid Norameda 4 mg/5 ml concentrate for solution for infusion");
        put("04751022900149", "Atosiban_Pharmidea_Latvia_5ML");
        put("04150163524519", "Bortezomib_Hikma_Germany");
        put("04150047133691", "Zoledron-Uropharm 4 mg/5 ml (1 St.)");
        put("04751022900293", "Carbetocin Pharmidea LV");
        put("04150166238789", "Micafungin Inresa 50mg");
        put("04150166238840", "Micafungin Inresa 100mg");
        put("05213009840002", "Sugammadex Pharmazac (HR) 100mg/ml vial 2ml");
        put("05060106551719", "Micafungin 100mg Flynn");
        put("05060106551702", "Micafungin 50mg Flynn");
        put("04744958010129", "Carbetocin Auxilia Pharm");
        put("05694230378777", "BORTEZOMIB W&H 3,5 MG");
        put("05694230378784", "Pemetrexed W&H 500 mg");
        put("03859893480638", "Deksmedetomidin Alpha Medical_HR");
        put("04750321000093", "Corvalolum 90 RFF");
        put("04750321200264", "Corvalolum 25 RFF");
        put("07680669960018", "Atosiban KLASA 6.75 mg/0.9 mL_CH");
        put("15012727915088", "Micafungin Wockhardt 50mg");
        put("15012727915095", "Micafungin Wockhardt 100mg");
        put("07680669960025", "Atosiban KLASA 37.5 mg/ml");
        put("04150166344169", "Micafungin 50 MG Pharmore");
        put("04150166344220", "Micafungin 100 MG Pharmore");
        put("08470007296539", "Micafungin Accord 50 MG");
        put("08470007296546", "Micafungin Accord 100 MG");
        put("05909991429928", "Atosiban Mercapharm 6.75 mg/ 0.9 ml");
        put("05909991429935", "Atosiban Mercapharm 37.5 mg/ 5 ml");
        put("04751022900880", "DATOCIN 100mcg/ ML INJ SOL 4X1ML");
        put("04751022900903", "TOCONORM 37,5MG/5ML INF CNC SOL 1X5ML");
        put("04751022900910", "TOCONORM 6,75MG/0,9ML INJ SOL 1X0,9ML");
        put("04150047133752", "Zoledron-Uropharm 4 mg/5 ml (4 St.)");
        put("04150157828241", "Zoledron-Uropharm 4 mg/5 ml (1 bottle, unsalable sample)");
        put("05213009840224", "Sugammadex Pharmazac (RO/BG) 100mg/ml vial 2ml");
        put("05213009840248", "Sugammadex Pharmazac (SI) 100mg/ml vial 2ml");
        put("06251065052723", "Veelbore 3.5 mg Powder for Solution for Infusion Vials Jordan");
        put("05600906914309", "Bortezomib Hikma, 3,5 mg, Pу para soluзгo injetаvel");
        put("03859893480515", "Atosiban Alpha-Medical 37,5mg/5ml koncentrat za otopinu za infuziju");
        put("03859893480522", "Atosiban Alpha-Medical 6,75mg/0,9ml otopina za injekciju");
        put("04751022900835", "Dexmedetomidine 2 ml Pharmidea Latvia");
        put("05999883507247", "MICAFUNGIN PHARMACENTER 50 mg");
        put("05999883507254", "MICAFUNGIN PHARMACENTER 100 mg");
        put("05909991446178", "Micafungin Accord 50 MG Poland");
        put("05909991446185", "Micafungin Accord 100 MG Poland");
        put("08594171980282", "KARBETOCIN AVMC");
        put("05055565774236", "Micafungin Accord 50 MG Portugal");
        put("05055565774243", "Micafungin Accord 100 MG Portugal");
        put("08719326062853", "Pemetrexed B-Medical");
        put("04150174382269", "Bort_Hikma_Germany_NEW");
        put("03859893480843", "Levosimendan Alpha");
        put("08719326062860", "Bortezomib B-medical");
    }};

    public String getNameByGTIN(String gtin){
        return gtinDatabase.get(gtin);
    }

}
