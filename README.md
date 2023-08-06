# HospitalAutomationSystems
Projede Java&Spring Boot kullanılmıştır. ORM aracı olarak Hibernate kullanılmıştır. Database olara PostgreSQL kullanılmıştır ve mapping işlemleri için ModelMapper kullanılmıştır 
Bu proje ile bir poliklinik oluşturulabilir ve polikliniğe ait doktorlar oluşturulabilir. 
Bunun yanı sıra Hasta oluşturulabilir ve o her hastaya ait raporlar, reçeteler ve sonuçlar oluşturulabilir. 
Tüm class'lar için @OneToMany ve @ManyToOne bağlantıları yapılmıştır. 
Testler PostMan ve Swagger-ui üzerinden başarıyla gerçekleştirilmiştir. 
Frontend tarafı ise HTML, CSS ile yazılmıştır ve projeye Thymeleaf yardımıyla bağlanmıştır.
Hastalar diledikleri gün ve saatte diledikleri doktora randevu alabileceklerdir. Eğer diledikleri gün ve saatte başka bir hasta randevu aldıysa ekrana uyarı mesajı gelecektir. 

