# Tutorial APAP
## Authors
* **Naifathiya Langitadiva** - *1906299055* - *B*

## Tutorial 7
### What I have learned today
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.  
    **Soal 1**  
    <img width="900" alt="no1" src="https://user-images.githubusercontent.com/90308363/143241512-dd53f28f-00a4-4606-b097-23fbd7a7b43f.png">
    Dibuat fungsi baru, yaitu `handleDeleteItemInCart`. Pada fungsi tsb, dicari tahu index dari item yang ingin dihapus dan 
    dipanggil method .splice() untuk menghapus item dari array cartItems. Lalu, state dari component diubah karena ada item yang dihapus. 
    Props dari Item, yaitu inCart, juga diubah untuk menandakan item sudah tidak berada pada cart.  
    
    **Soal 2**  
    <img width="900" alt="no2b" src="https://user-images.githubusercontent.com/90308363/143241778-52573d8c-7fc2-4dc1-a090-d2df71e84e85.png">
    <img width="900" alt="no2" src="https://user-images.githubusercontent.com/90308363/143241681-0913d6e0-da40-4e76-a876-a9e04156bcae.png">
    <img width="1280" alt="Screen Shot 2021-11-24 at 20 14 32" src="https://user-images.githubusercontent.com/90308363/143245368-5f6b7193-610a-4b2e-bbff-425eaff86e64.png">
    Pada fungsi `handleDeleteItemInCart`, disisipkan line untuk mengubah state balance ketika item dari cart dihapus. Balance akan ditambahkan dengan 
    props price dari item terkait. Pada fungsi `handleAddItemToCart`, juga disisipkan line untuk mengubah stat balance. Balance akan 
    dikurangi dengan props price dari item terkait.  
    
    **Soal 3**  
    <img width="900" alt="no3" src="https://user-images.githubusercontent.com/90308363/143241938-e66e7a31-2f6b-407a-8025-419e94ba2f1b.png">
    <img width="1280" alt="Screen Shot 2021-11-24 at 20 15 29" src="https://user-images.githubusercontent.com/90308363/143245381-e5369b55-f951-43c1-b8c8-ec8bfc7f874d.png">
    Pada fungsi `handleAddItemToCart`, disisipkan if-condition apabila state balance saat ini mencukupi newItem yang ingin ditambahkan. 
    Jika cukup, maka item akan ditambahkan ke cart. Jika tidak cukup, maka akan masuk ke else dan ditampilkan alert yang memberi tahu 
    bahwa balance saat ini tidak cukup, item juga gagal untuk ditambahkan ke cart.
    
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?  
Berdasarkan pemahaman saya, state merupakan sebuah objek yang menyimpan informasi terkait component dan dapat berubah seiring waktu berjalan. 
Seperti pada tutorial kali ini, kita merubah state ketika aksi-aksi tertentu dilakukan. State juga hanya dapat diakses/diubah di dalam 
component secara langsung.  Sedangkan, props merupakan objek/komponen yang tidak dapat berubah di dalam komponennya dan hanya dapat dilihat. Props 
menyimpan nilai dari atribut-atribut komponen. Berbeda dengan state, props dapat melakukan passing data dari suatu komponen ke 
komponen lain, seperti pada tutorial ketika props dari Item di-pass ke Home.
3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.  
Ya, sebaiknya kita menggunakan component dalam React. Alasannya karena component yang sama dapat digunakan kembali, lalu perubahan dapat terjadi 
secara instan tanpa perlu reload page-nya. Code juga terlihat lebih rapi dan stabil. Selain itu, aplikasi web yang dinamis jadi lebih 
mudah dibuat dengan bantuan component-component yang ada.
4. Apa perbedaan class component dan functional component?  
   - Functional Component merupakan fungsi JavaScript biasa yang menerima props sebagai argymen dan mengembalikan elemen React. 
   Sedangkan, Class Component mengharuskan kita untuk extend dari component React dan membuat fungsi render yang mengembalikan 
   elemen React.
   - Functional Component tidak menggunakan constructor. Class Component menggunakan constructor untuk menyimpan state.
   - Functional Component dikenal sebagai stateless component karena hanya menerima dan menampilkan data dalam beberapa bentuk yang 
   utamanya bertanggung jawab untuk merender UI. Class Component dikenal sebagai stateful component karena diimplementasikan logic dan state.
5. Dalam react, apakah perbedaan component dan element?  
   React Component:
   - Sebuah template, dapat berupa function maupun class dengan method render.
   - Mengambil props sebagai input dan mengembalikan JSX tree sebagai output
   - Ketika React melihat element dengan tipe function/class, ia akan berkonsultasi dengan component tersebut untuk mengetahui element mana yang harus dikembalikan, dengan menggunakan props yang sesuai.  

    React Element:
   - Sebuah hasil pengembalian dari component, yaitu objek yang menjelaskan nodes DOM yang direpresentasikan suatu component.
   - Dengan functional component, element ini adalah objek yang dikembalikan oleh function tsb.
   - Dengan class component, element-nya adalah objek yang dikembalikan oleh fungsi render milik component.
   - Bukan merupakan sesuatu yang dapat dilihat di browser, melainkan objek di memori.

Referensi:  
https://www.geeksforgeeks.org/differences-between-functional-components-and-class-components-in-react/  
https://stackoverflow.com/questions/30971395/difference-between-react-component-and-react-element  
https://www.uxpin.com/studio/blog/reactjs-benefits-and-components/

## Tutorial 6
### What I have learned today
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?  
Otentikasi merupakan proses pemeriksaan detail user untuk mengidentifikasi dan memberi hak/akses masuk ke dalam sistem. Otentikasi 
pada tutorial kali ini adalah adanya proses memasukkan username dan password. Contoh kode implementasi terkait otentikasi ada pada file `WebSecurityConfig`, yaitu:
    ```
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    ```
   Sedangkan, Otorisasi merupakan proses pemeriksaan hak apa saja yang user terima untuk dapat mengakses suatu fitur/aksi di dalam sistem. 
Contoh kode implementasi terkait otorisasi ada pada file `WebSecurityConfig`, antara lain:  
    ```
    .authorizeRequests()
    .antMatchers("/css/**").permitAll()
    .antMatchers("/js/**").permitAll()
    .antMatchers("/user/add").hasAuthority("Admin")  
    .antMatchers("/user/viewall").hasAuthority("Admin")  
    .antMatchers("/user/delete/**").hasAuthority("Admin")  
    .antMatchers("/destinasi/add").hasAuthority("Agen")  
    ```
    Kode-kode tersebut memberi hak khusus kepada suatu role agar dapat mengakses halaman terkait.

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.  
BCryptPasswordEncoder adalah salah satu encoder password yang digunakan dalam modul spring boot security untuk encoding dan decoding 
password, serta validasi. Pada BCryptPasswordEncoder, digunakan algoritma BCrypt yang merupakan sebuah algoritma enkripsi 
satu arah. Digunakan pula berbagai parameter yang dapat dikonfigurasi untuk menentukan kompleksitas dari algoritma dan didefinisikan 
pada constructor class BCryptPasswordEncoder. Dalam aplikasinya, password yang dimasukkan oleh user akan dienkripsi lalu disimpan 
ke dalam database sebagai 'encrypted password'. Karena BCryptPasswordEncoder bersifat satu arah, maka tidak mendekripsi password yang 
telah dienkripsi. Oleh sebab itu, disediakan method `matches()` yang dapat memeriksa password mentah dengan password yang telah dienkripsi.  
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?  
Berdasarkan situs-situs yang saya baca, keduanya memiliki kelebihan dan kekurangannya masing-masing. Mana yang lebih baik tergantung 
pada tujuan tim pengembang karena fungsi encryption dan hashing berbeda pula. Namun jika dilihat dari segi keamanan, maka hashing 
akan menjadi pilihan yang lebih baik karena bersifat satu arah dan mengacak teks mentah untuk menghasilkan pesan yang unik. Sedangkan, 
encryption bersifat dua arah sehingga yang terenkripsi dapat didekripsikan kembali dengan key yang tepat.
4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!  
UUID merupakan singkatan dari Universally Unique Identifier yang terlihat seperti urutan 32 karakter huruf dan angka yang dipisahkan oleh tanda hubung. 
Nyatanya, UUID merupakan 128-bit number yang mengidentifikasi objek/data internet secara unik. 
UUID berguna untuk memberi entitas nama khususnya sendiri, misal dalam sebuah database. Dengan digunakannya UUID, keamanan data user 
akan meningkat karena dilakukan hashing hingga id user jadi tidak mudah untuk diserang/retas.
5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?  
Class UserDetailsServiceImpl.java merupakan implementasi dari interface (UserDetailsService) yang ada pada framework spring security dan digunakan untuk membangun 
otentikasi user. Pada class ini, dihasilkan objek UserDetails dari method `loadUserByUsername` yang akan memberikan informasi terkait user, serta memberi otorisasi 
untuk user sesuai role-nya.  


Referensi:  
https://www.yawintutor.com/encode-decode-using-bcryptpasswordencoder-in-spring-boot-security/  
https://gcn.com/articles/2013/12/02/hashing-vs-encryption.aspx  
https://www.clickssl.net/blog/difference-between-hashing-vs-encryption  

## Tutorial 5
### What I have learned today
1. Apa itu Postman? Apa kegunaannya?  
Postman adalah aplikasi yang dapat berfungsi sebagai REST client untuk menguji coba REST API. Dengan Postman, developer dapat 
menguji API yang telah mereka buat, seperti yang kita lakukan pada tutorial 5 ini. Postman juga dapat digunakan untuk mengumpulkan API 
yang dapat dibuat menjadi sebuah dokumentasi utuh untuk satu projek tertentu. Beberapa uji coba yang dapat dilakukan melalui 
Postman, antara lain GET seluruh data maupun data tertentu, POST untuk menambah data, PUT untuk meng-update data dengan id tertentu, 
dan DELETE untuk menghapus data dengan id tertentu.
2. Jelaskan fungsi dari anotasi `@JsonIgnoreProperties` dan `@JsonProperty`.
    - `@JsonIgnoreProperties` digunakan pada class level untuk menandai properti atau daftar properti yang akan diabaikan. 
    @JsonIgnoreProperties digunakan untuk menekan serialisasi properti (selama serialisasi), atau mengabaikan pemrosesan pembacaan 
    properti JSON (selama deserialisasi).
    - `@JsonProperty` digunakan untuk memetakan nama properti dengan key JSON selama serialisasi dan deserialisasi. @JsonProperty 
    dapat meng-override behavior serialisasi dengan menggunakan atribut String yang menentukan nama yang harus dipetakan ke field selama serialisasi. 
    Selain itu, dapat digunakan pula selama deserialisasi saat nama properti JSON dan nama bidang objek Java tidak cocok.
3. Apa kegunaan atribut WebClient?  
WebClient adalah komponen yang digunakan untuk membuat panggilan HTTP ke layanan lain. WebClient adalah bagian dari web reaktif framework Spring 
yang berfunngsi untuk membantu membangun aplikasi reaktif dan non-blocking. WebClient mendukung requests web non-blocking menggunakan 
fitur dari library Webflux. Selain itu, WebClient juga dapat digunakan dalam mode blocking, di mana kode akan menunggu request berakhir sebelum 
melanjutkan lebih jauh.
4. Apa itu `ResponseEntity` dan `BindingResult`? Apa kegunaannya?
    - `ResponseEntity` merupakan extension dari HttpEntity yang merepresentasikan seluruh HTTP responses, mulai dari status code, header, dan body. Karena itu, kita dapat 
      menggunakannya untuk mengkonfigurasi HTTP response sepenuhnya. ResponseEntity juga memungkinkan kita untuk memodifikasi response 
      dengan header dan status code opsional. ResponseEntity digunakan saat kita perlu mengubah header atau status code berdasarkan business logic 
      maupun request yang masuk.
    - `BindingResult` menyimpan hasil validasi dan binding, serta berisi error yang mungkin terjadi. Kita dapat menggunakan objek 
    BindingResult sebagai argumen untuk metode validasi Validator di dalam Controller. BindingResult menentukan bagaimana objek 
    harus menyimpan dan mengambil hasil validasi.

Referensi:  
https://refactory.id/post/7366-postman-tukang-post-membantu-testing-api/  
https://www.amitph.com/introduction-to-spring-webclient/#What_is_Spring_WebClient  
https://technicalsand.com/using-responseentity-in-spring/#0-what-is-responseentity  
https://dzone.com/articles/jackson-annotations-for-json-part-4-general


## Tutorial 4
### What I have learned today
1. Jelaskan perbedaan th:include dan th:replace!  
Dengan `th:include`, isi fragment akan diletakkan di dalam tag yang bersangkutan tapi tidak termasuk tag fragment-nya.  
Sedangkan, `th:replace` akan menggantikan tag dengan konten yang didefinisikan pada fragment. Ini akan menghapus tag asal, 
lalu akan menambahkan fragment yang ditentukan termasuk dengan tag-nya. th:replace tidak mengharuskan kita untuk mencocokkan 
tag HTML di fragment.  
2. Jelaskan apa fungsi dari `th:object`!  
`th:object` digunakan untuk menentukan objek yang akan terikat oleh data dari form yang dibuat/kirimkan. Di dalam <form> tag, 
hanya boleh terdapat 1 th:object yang didefinisikan karena form HTML tidak bisa nested. Ekspresi yang digunakan untuk mendefinisikan 
objek harus merujuk ke objek bean secara langsung. 
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?  
`*` atau asterisk syntax mengevaluasi ekspresi pada objek yang dipilih daripada keseluruhan konteks. Syntax ini dipakai ketika 
kita hanya ingin memanggil atribut dari objek. Misalkan untuk objek TravelAgensiModel agensi, syntax untuk mengakses atributnya 
adalah `*{noAgensi}`. Syntax ini sering digunakan untuk atribut th:field pada pembuatan form.
Sedangkan, `$` atau dollar syntax merupakan bentuk ekspresi standar. Syntax untuk mengakses atributnya harus dengan objek utamanya. 
Misalkan untuk objek TravelAgensiModel agensi, cara mengaksesnya adalah `${agensi.noAgensi}`.

## Tutorial 3
### What I have learned today
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
    - @AllArgsConstructor berfungsi untuk menghasilkan constructor dengan 1 parameter untuk setiap field pada class tersebut.
    - @NoArgsConstructor berfungsi untuk menghasilkan constructor tanpa parameter.
    - @Setter, @Getter berfungsi untuk menghasilkan default setter dan getter secara otomatis untuk setiap field.
    - @Entity merupakan anotasi JPA untuk membuat objek ini siap disimpan di penyimpanan data berbasis JPA.
    - @Table berfungsi untuk menyediakan tabel yang memetakan entitas ini.
2. Pada class TravelAgensiDb, terdapat method findByNoAgensi, apakah kegunaan dari method
tersebut?  
`findByNoAgensi` digunakan untuk mencari agensi berdasarkan no agensi. Method ini mengembalikan Optional yang merupakan sebuah 
container berisi not-null object. Optional digunakan untuk mewakili null dengan nilai tidak ada. Keberadaan objek dapat diketahui 
dengan method isPresent() dan dapat diambil dengan method get().
3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn  
    - @JoinTable menyimpan id dari kedua entity ke tabel yang terpisah. Sedangkan, @JoinColumn menyimpan id dari entity lain di 
    kolom baru pada tabel yang sama.
    - @JoinColumn digunakan ketika antar entity memiliki direct relationship. Sedangkan, @JoinTable digunakan ketika 
    kita me-manage relationship antar entity di tabel yang lain.
    - @JoinColumn digunakan untuk performa yang lebih baik dan tidak butuh join tabel tambahan. Sedangkan, @JoinTable digunakan 
    ketika dibutuhkan database yang lebih dinormalisasi.
4. Pada class TourGuideModel, digunakan anotasi @JoinColumn pada atribut agensi, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull
`name` adalah nama untuk kolom yang ada pada database. `referencedColumnName` adalah nama kolom yang ditunjuk oleh atribut agensi class TourGuideModel. 
Sedangkan, `nullable` merupakan penanda bahwa atribut ini tidak boleh berisi null/kosong.  
`nullable` dan `@NotNull` pada dasarnya mencegah penyimpanan nilai null pada database. `nullable` merupakan bagian dari spesifikasi JPA 
dalam menyatakan atribut yang bukan null untuk validasi dan menunjukkan rincian skema database. Validasi dilakukan bukan oleh Hibernate, 
melainkan oleh database. Sedangkan, `@NotNull` didefinisikan dalam spesifikasi BeanValidation. Ini berarti penggunaannya tidak terbatas 
hanya pada entity. @NotNull memberi tahu implementasi BeanValidation untuk memeriksa apakah atributnya bukan null.
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER  
    - `FetchType.LAZY` mendefinisikan cara/strategi untuk mengambil data dari database dengan malas saat pertama kali diakses. LAZY 
    merupakan tipe fetch default. Hibernate tidak akan me-load relationship untuk suatu objek tertentu.
    - `FetchType.EAGER` mendefinisikan cara/strategi untuk mengambil data dari database secara eager (penuh semangat). Secara default, 
    tipe ini akan me-load semua relationship yang berkaitan dengan suatu objek yang sedang dimuat oleh Hibernate.
    - `CascadeType.ALL` digunakan untuk menyebarkan (propagates) semua operasi, termasuk yang Hibernate-specific dari parent ke entitas child.


## Tutorial 2
### What I have learned today

### Pertanyaan:
1. Cobalah untuk menambahkan sebuah Agensi dengan mengakses link berikut:  
http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx  
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.  
<img width="1280" alt="pert1" src="https://user-images.githubusercontent.com/90308363/133433610-4f43e10e-66c6-40bf-ac58-82600c4a769e.png">  
Pada saat mengakses link, kita ditujukan ke halaman Whitelabel Error Page. Hal tersebut dikarenakan View yang telah 
dicantumkan pada Controller, yaitu `add-agensi` belum dibuat. Pada konsep MVC, View berfungsi untuk menampilkan tampilan kepada client. 
Karena View (template HTML) belum dibuat, agensi tidak bisa ditambahkan.  

2. Menurut kamu anotasi `@Autowired` pada class Controller tersebut merupakan implementasi dari konsep apa? 
Dan jelaskan secara singkat cara kerja `@Autowired` tersebut dalam konteks service dan controller yang telah kamu buat.  
@Autowired membolehkan kita untuk menyelesaikan dan meng-inject hal yang ingin dikolaborasikan. Implementasi ini merupakan 
konsep dari **Dependency Injection**. Dengan @Autowired, Spring dapat meng-handle instansiasi dari suatu kelas.  
@Autowired memungkinkan kita mengelola servis dalam container dengan konfigurasi minimal. @Autowired akan membaca petunjuk 
pada method dan secara otomatis meneruskan servis yang sesuai. Pada Controller, Spring akan mencari class yang propertinya 
cocok dan akan meng-inject secara otomatis. 

3. Cobalah untuk menambahkan sebuah Agensi dengan mengakses link berikut:  
http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom  
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.  
<img width="1280" alt="pert3" src="https://user-images.githubusercontent.com/90308363/133433751-fda8887a-5e6c-4822-bd61-215219d5a4b0.png">  
Pada saat mengakses link, kita ditujukan ke halaman Whitelabel Error Page. Hal tersebut dikarenakan adanya kekurangan parameter 
pada link yang dimasukkan. Untuk dapat menampilkan halaman yang sesuai, dibutuhkan parameter yang lengkap. Pada kasus ini, 
noTelepon tidak dimasukkan sehingga muncul error.

4. Jika Papa APAP ingin melihat Travel Agensi dengan nama Papa APAP, link apa yang harus diakses?  
Program pergipergi saat ini tidak menyediakan pencarian dengan nama. Oleh karena itu, Papa APAP dapat mengunjungi http://localhost:8080/agensi/viewAll 
untuk melihat idAgensi miliknya (yaitu 1), lalu mengunjungi http://localhost:8080/agensi/view?idAgensi=1 atau http://localhost:8080/agensi/view/id-agensi/1

5. Tambahkan 1 contoh Travel Agensi lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/agensi/viewAll , 
apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.  
Tambahan agensi: http://localhost:8080/agensi/add?idAgensi=2&namaAgensi=Mama%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx  
Halaman akan menampilkan list travel agensi yang telah dibuat. Berikut bukti screenshot-nya:
<img width="1280" alt="pert5" src="https://user-images.githubusercontent.com/90308363/133431764-93cdde63-f4f3-443f-a281-414db4b78a91.png">  
<img width="1280" alt="pert5hasil" src="https://user-images.githubusercontent.com/90308363/133431787-61d4e555-671f-4197-ad89-cc11b623e5b1.png">
  
  
## Tutorial 1
### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?  
Issue Tracker adalah sebuah *tracker* yang disediakan oleh Github dan terintegrasi dengan repositori yang 
sedang dikembangkan sehingga kita dapat *keep on track* dengan aktivitas yang terkait. Masalah yang dapat
diselesaikan dengan Issue Tracker, antara lain menghubungkan issue ketika melakukan pull request. Ketika 
request berhasil dimerge, issue yang terhubung akan ditutup.
2. Apa perbedaan dari `git merge` dan `git merge --squash`?  
Pada `git merge`, setiap commit pada branch akan ditambahkan menuju branch master melalui merge commit.
Sedangkan pada `git merge --squash`, semua commit dari tiap branch akan diambil dan bergabung menjadi 1 squash tunggal 
menuju branch master. Apabila konflik ditemukan, kita dapat menyelesaikannya secara manual.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?  
Version Control merupakan sistem yang dapat merekam jejak perubahan dari file. Karena itu, dengan menggunakan
sistem ini, kita dapat mengingat/melihat kembali versi yang belum diubah/dihapus. Selain itu, dengan Version 
Control System, kita dapat bekerja dengan tim secara efisien dengan adanya *branching* dan *merging*.
### Spring
4. Apa itu library & dependency?  
Library adalah kumpulan package yang berisi pengelompokkan kelas-kelas dan interface yang terkait dan dapat digunakan. Dependency adalah 
sebuah objek/servis yang dapat digunakan. Sebuah aplikasi dibentuk dari banyak *layer*. Setiap *layer* bergantung pada 
*layer* lainnya. Dependency merupakan *layer* yang digantungi.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?  
Maven merupakan salah satu *build tools* yang menggunakan konsep Project Object Model (XML file) berisi informasi 
untuk membuat suatu *project*. Dengan Maven, kita dapat mengatur dependency yang dibutuhkan. Maven akan secara otomatis
men-*download* file-file dari dependency sehingga dapat digunakan. Alternatif lain dari Maven, yaitu Gradle dan Apache Ant.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?  
Dengan Spring Framework, kita juga dapat mengembangkan aplikasi untuk keamanan dan big data.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?  
@RequestParam baik digunakan ketika data ditemukan di parameter *query*. Sedangkan, @PathVariable digunakan untuk RESTful 
*web service.* 
Perbedaan:
    - @RequestParam mengekstrak *value* dari *query* String, @PathVariable mengekstrak value dari URI path
    - @RequestParam mengekstrak *value* yang telah di-*encode*, @PathVariable mengekstrak value yang belum di-*encode*  
### What I did not understand
- [ ] Konsep nyata `git merge --squash`
- [ ] Konsep MVC secara *overall*
- [ ] Teknik Dependecy Injection  
Hal-hal yang masih belum paham, salah satunya adalah konsep nyata `git merge --squash`. Sampai saat ini (08/09), saya belum pernah 
menggunakan cara tersebut ketika melakukan *merging* sehingga belum terlihat perbedaan yang signifikan antara `git merge` dan `git merge --squash`. 
Selain itu, saya masih perlu mengingat kembali konsep MVC yang telah dipelajari di DDP2.  
