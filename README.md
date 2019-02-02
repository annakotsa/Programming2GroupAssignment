# Programming2GroupAssignment
JavaDevs Team main Repository for the Group Semester Assignment at Programming II course.

Short explanation regarding our code's functionality.

1.Class DATABASE

Η Database είναι η κλάση η οποία εκτελεί 3 βασικές λειτουργίες. Η πρώτη λειτουργία της κλάσης είναι να ζητήσει 
από το χρήστη και να αποθηκεύσει το όνομα του καθώς και το όνομα της βάσης του. 
Η δεύτερη λειτουργία της είναι να ρωτήσει το χρήστη αν επιθυμεί να συνδέσει τη βάση του με κάποια ήδη υπάρχουσα βάση κατασκευασμένη 
με SQL και αν ναι, τότε να δώσει την διεύθυνση της (url). 
Τέλος, η τρίτη λειτουργία της Database είναι η εμφάνιση του αρχικού μενού. 
Αφού εμφανίσει το αρχικό μενού ζητάει από το χρήστη να επιλέξει μία από τις επιλογές. Ανάλογα με την επιλογή του χρήστη, 
η κλάση καλεί την αντίστοιχη μέθοδο από την κλάση Process. Για να αποφευχθούν πιθανά λάθη έχουμε χρησιμοποιήσει σε αυτή την κλάση 
δύο τύπους exceptions. Έχουμε χρησιμοποιήσει την InputMismatchException για να βεβαιωθούμε πως ο χρήστης δεν θα δώσει απάντηση 
διαφορετικού τύπου από αυτή που απαιτείται και την SQLException σε περίπτωση που δεν καταφέρει να συνδεθεί με τον SQL server.

2.Class PROCESS

2.a INPUT function

Όσον αφορά τη λειτουργία INPUT, στη μέθοδο input της κλάσης Progress εισάγουμε τα δεδομένα σε ένα LinkedList. Στη μέθοδο addRecord,
μετά την επιλογή νούμερο 1 στο μενού, ο χρήστης καλείται να δώσει τα αντίστοιχα πεδία της βάσης δεδομένων του. Σε περίπτωση εισαγωγής 
κενού στοιχείου στο πρωτεύον κλειδί ή εισαγωγής τιμής ενός προηγούμενου πρωτεύον κλειδιού τότε το πρόγραμμα 
ζητάει την επανάληψη εισαγωγής των δεδομένων. 

2.b EDIT fuction

Όσον αφορά τη λειτουργία EDIT, η μέθοδος edit, αφού δεχθεί μια τιμή, ελέγχει αν η βάση είναι άδεια. Σε περίπτωση που δεν είναι, ψάχνει να βρεί σε ποιά γραμμή 
η τιμή που δόθηκε είναι primary key, μέσω της μεθόδου searchByPrimKey. Εφόσον τη βρει, ζητά απο τον χρήστη να δώσει το όνομα του 
field του οποίου την καταχώρηση θέλει να επεξεργαστεί και μετά του ζητά να δώσει την νεα τιμή που θέλει να καταχωρήσει στην θέση της 
προηγούμενης. Αν η τιμή δεν είναι null ή ιδια με την προηγούμενη, η τιμή αλλάζει. Το exception της μεθόδου edit, 
ελέγχει αν δίνεται στο προγραμμα τιμή η οποία δεν είναι τύπου integer και στην περίπτωση αυτή δίνει το αντίστοιχο μήνυμα.

2.c DELETE function

Όσον αφορά τη λειτουργία DELETE, η μέθοδος deletionChoice τυπώνει τις επιλογές. Ο χρήστης διαλέγει από το μενού ανάλογα 
με την εκάστοτε λειτουργία που θέλει να εκτελέσει. Έχει δύο επιλογές. Εάν πατήσει 1, τότε διαγράφεται όλη η βάση δεδομένων, 
συμπεριλαμβανομένου των εγγραφών και των πεδίων (μέθοδος deleteTheBase). Αυτό γίνεται μόνο στην περίπτωση που η βάση δεν είναι ήδη κενή.
Εάν πατήσει 2 διαγράφεται μια συγκεκριμένη εγγραφή από τη βάση την οποία καθορίζει ο χρήστης (μέθοδος deleteTheRecord). 
Στην περίπτωση που θέλει να επιστρέψει στο βασικό μενού τότε πατάει 3.

2.d VIEW function

Όσον αφορά τη λειτουργία VIEW, η μέθοδος viewList δίνει στον χρήστη τη δυνατότητα να επιλέξει την μέθοδο και τον τρόπο προβολής 
της λίστας εκχωρώντας στην μεταβλητή choice την επιλογή του χρήστη. Αν ο χρήστης θέλει να γίνει προβολή όλης της λίστας πρέπει να 
πατήσει το κουμπί 0, αν θέλει να του εμφανιστεί μια εγγραφή της λίστας βάσει ενός πρωτεύοντος κλειδιού πρέπει να πατήσει το κουμπί 1 
ή τέλος αν θέλει να του εμφανιστεί/ούν η/οι εγγραφή/ές βάσει ενός χαρακτηριστικού (πχ οι εγγραφές με το όνομα «Γιάννης») πρέπει να 
πατήσει το κουμπί 2. Αν πατήσει οποιοδήποτε άλλο κουμπί, η boolean μεταβλητή cont που έχει οριστεί στην αρχή ως true γίνεται false 
και εμφανίζεται στον χρήστη το κατάλληλο μήνυμα.

Η μέθοδος viewEverything, εφόσον ο χρήστης την έχει καλέσει πατώντας το κουμπί 0,  ελέγχει αρχικά αν η λίστα είναι άδεια και αν είναι 
εμφανίζει το κατάλληλο μήνυμα. Αν η λίστα δεν είναι άδεια, εμφανίζει όλες τις εγγραφές της.
Η μέθοδος searchbyPrimKey καλείται από την μέθοδο viewbyPrimKey. Η μέθοδος αυτή ζητά από τον χρήστη να καταχωρήσει το πρωτεύον κλειδί 
βάσει του οποίου θέλει να του εμφανιστεί η εγγραφή. Έπειτα, ελέγχει αν υπάρχει αυτή η εγγραφή και αφού βρει ότι υπάρχει, αποθηκεύει 
στην μεταβλητή position την θέση του πρωτεύοντος κλειδιού στη λίστα. Αν δεν βρεθεί σε όλο το μήκος της λίστας καμία εγγραφή με το 
ζητούμενο πρωτεύον κλειδί, η μέθοδος επιστρέφει -1.

Η μέθοδος viewbyPrimKey αρχικά ελέγχει αν η λίστα είναι άδεια και σε περίπτωση που είναι, εμφανίζεται κατάλληλο ενημερωτικό μήνυμα. 
Σε περίπτωση που η λίστα δεν είναι άδεια, η μέθοδος καλεί την μέθοδο searchbyPrimKey και αποθηκεύει στην μεταβλητή position την θέση 
που έχει οριστεί από την τελευταία μέθοδο. Αν η μεταβλητή position έχει τιμή -1, τότε εμφανίζεται το κατάλληλο ενημερωτικό μήνυμα με 
την δυνατότητα επιλογής στον πελάτη να ξαναπροσπαθήσει, αν πατήσει το κουμπί 1. Όταν η τιμή της μεταβλητής position δεν είναι -1, τότε 
καλείται η μέθοδος get() και έχοντας ως όρισμα την μεταβλητή position εμφανίζεται η εγγραφή που περιέχει το πρωτεύον κλειδί.

2.e SAVE function

Όσον αφορά τη λειτουργία SAVE, η μέθοδος saveDatabase επιτρέπει στο χρήστη να αποθηκεύσει τη βάση που έχει δημιουργήσει σε μορφή 
αρχείου στον υπολογιστή του. Εάν η αποθήκευση γίνει επιτυχώς, εμφανίζεται το ανάλογο μήνυμα στο χρήστη. Διαφορετικά, σε περίπτωση 
που το αρχείο δεν μπορεί να αποθηκευτεί για ορισμένο λόγο, εμφανίζεται στο χρήστη το κατάλληλο ενημερωτικό μήνυμα και έπειτα το 
πρόγραμμα τερματίζεται.



Authors:
@Ioanna Kalogeropoulou
@Pantelis Kirpoglou
@Anna Kotsa
@Giannis Methenitis
@Aliki Ntouzgou
@Aristi Syriou




























