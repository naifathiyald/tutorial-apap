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
Sedangkan pada `git merge -squash`, semua commit dari tiap branch akan diambil dan bergabung menjadi 1 squash tunggal 
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
Hal-hal yang masih belum paham, salah satunya adalah konsep nyata `git merge --squash`. Sampai saat ini (08/09), saya belum pernah 
menggunakan cara tersebut ketika melakukan *merging*. Selain itu, saya masih perlu mengingat kembali konsep MVC yang telah dipelajari di DDP2.  
- [x] Kenapa saya harus belajar APAP?
Karena Arsitektur dan Pemrograman Aplikasi Perusahaan merupakan salah satu mata kuliah yang wajib saya ikuti sebagai 
mahasiswa Fasilkom UI dan merupakan hal yang (menurut saya) wajib saya pahami agar dapat menjadi bekal untuk ke depannya.