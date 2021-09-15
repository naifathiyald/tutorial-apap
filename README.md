# Tutorial APAP
## Authors
* **Naifathiya Langitadiva** - *1906299055* - *B*

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
