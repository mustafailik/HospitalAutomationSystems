(function ($) {
    "use strict";

    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 992) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }

        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });


    // Date and time picker
    $('.date').datetimepicker({
        format: 'YYYY-MM-DD',
    });
    $('.time').datetimepicker({
        format: 'HH:mm',
    });


    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Price carousel
    $(".price-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        margin: 45,
        dots: false,
        loop: true,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsive: {
            0: {
                items: 1
            },
            992: {
                items: 2
            },
            1200: {
                items: 3
            }
        }
    });


    // Team carousel
    $(".team-carousel, .related-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        margin: 45,
        dots: false,
        loop: true,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsive: {
            0: {
                items: 1
            },
            992: {
                items: 2
            }
        }
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        items: 1,
        dots: true,
        loop: true,
    });

    if (window.location.href.includes('appointmentactivity')) {
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);

        fetch('/api/appointments/' + urlParams.get('id'), {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById('patientName').value = data.patientName;
                document.getElementById('patientSurName').value = data.patientSurName;
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
        var cancelAppointmentBtn = document.getElementById("cancelAppointmentBtn");
        cancelAppointmentBtn.addEventListener("click", cancelAppointment, false);
        cancelAppointmentBtn.param = urlParams.get('id');

        var okAppointmentBtn = document.getElementById("okAppointmentBtn");
        okAppointmentBtn.addEventListener("click", okAppointment, false);
        okAppointmentBtn.param = urlParams.get('id');
    }
    if (window.location.href == 'http://localhost:8080/appointments') {


        fetch('/api/appointments/getByPatientId?patientId=' + getCookie("userID"), {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    data.forEach(addAppointmentRow);
                    data.forEach(function (item) {
                        var cancelAppointmentBtn = document.getElementById("cancelAppointmentBtn" + item.appointmentId);
                        cancelAppointmentBtn.addEventListener("click", cancelAppointmentEvt, false);
                        cancelAppointmentBtn.param = item.appointmentId;
                    });

                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
    }
    if (window.location.href == 'http://localhost:8080/prescription') {


        fetch('/api/prescriptions/?patientId=' + getCookie("userID"), {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    data.forEach(addPrescriptionRow);

                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
    }

    function addPrescriptionRow(item) {
        var prescriptionTbl = document.getElementById("prescriptionTbl");
        var tbRow = '<tr> <td>' + moment(item.prescriptionTime).format('DD/MM/YYYY HH:mm') + '</td> <td>' + item.patientName + ' ' + item.patientSurName + '</td><td>' + item.polyclinicName + '</td> <td>' + item.content + '</td></tr>';
        prescriptionTbl.innerHTML = prescriptionTbl.innerHTML + tbRow;

    }
    if (window.location.href == 'http://localhost:8080/report') {
        fetch('/api/reports/?patientId=' + getCookie("userID"), {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    data.forEach(addReportRow);

                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
    }
    function  addReportRow(item){
        var reportTbl = document.getElementById("reportTbl");
        var tbRow ='<tr> <td>'+moment( item.reportTime).format('DD/MM/YYYY HH:mm')+'</td> <td>'+item.patientName+' '+item.patientSurName +'</td><td>'+item.polyclinicName+'</td> <td>'+item.content+'</td></tr>';
        reportTbl.innerHTML = reportTbl.innerHTML+tbRow;

    }

    if(window.location.href == 'http://localhost:8080/appointmentsfordoctor'){


        fetch('/api/appointments/getByDoctorId?doctorId='+getCookie("doctorID"), {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    data.forEach(addAppointmentRowForDoctor);
                    data.forEach(function (item) {
                        var cancelAppointmentBtn = document.getElementById("cancelAppointmentBtn"+item.appointmentId);
                        cancelAppointmentBtn.addEventListener("click", cancelAppointment ,false);
                        cancelAppointmentBtn.param= item.appointmentId;
                        var redirectAppointmentBtn = document.getElementById("redirectBtn"+item.appointmentId);
                        redirectAppointmentBtn.addEventListener("click", redirectAppointment ,false);
                        redirectAppointmentBtn.param= item.appointmentId;


                    });

                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
    }

    if(window.location.href == 'http://localhost:8080/appointment'){

        document.getElementById("name").value = getCookie('name');
        document.getElementById("surname").value = getCookie('surname');
        fetch('/api/polyclinics/getAll', {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    data.forEach(addPolyclinicsOption);

                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
        document.getElementById("polyclinicsSelect").addEventListener("change", onChangePolyclinicSelect);
        document.getElementById("addAppointmentBtn").addEventListener("click", addAppointment);

    }
    function  addAppointmentRowForDoctor(item){

        var appointmentsTbl = document.getElementById("appointmentsTbl");
        var tbRow ='<tr> <td>'+moment( item.appointmentTime).format('DD/MM/YYYY HH:mm')+'</td> <td>'+item.patientName+' '+item.patientSurName +'</td><td>'+item.polyclinicName+'</td> <td>'+item.doctorName +' '+item.doctorSurName+'</td> ' +
            '<td>'+item.status+'</td><td><button class="btn btn-sm '+ (item.status=="Muayene Bekliyor" ? "btn-danger" :  "btn-outline-dark")+
            '" id="cancelAppointmentBtn'+item.appointmentId+'"   type="submit">İptal</button><button class="btn btn-sm  m-lg-1 '+ (item.status=="Muayene Bekliyor" ? "btn-primary" :  "btn-outline-dark")+
            '" id="redirectBtn'+item.appointmentId+'"   type="submit">Muayene Başlat</button></td></tr>';
        appointmentsTbl.innerHTML = appointmentsTbl.innerHTML+tbRow;

    }

    function  addAppointmentRow(item){
        var appointmentsTbl = document.getElementById("appointmentsTbl");
        var tbRow ='<tr> <td>'+moment( item.appointmentTime).format('DD/MM/YYYY HH:mm')+'</td> <td>'+item.patientName+' '+item.patientSurName +'</td><td>'+item.polyclinicName+'</td> <td>'+item.doctorName +' '+item.doctorSurName+'</td> ' +
            '<td>'+item.status+'</td><td><button class="btn '+ (item.status=="Muayene Bekliyor" ? "btn-danger" :  "btn-outline-dark")+
        '" id="cancelAppointmentBtn'+item.appointmentId+'"   type="submit">İptal</button></td></tr>';
        appointmentsTbl.innerHTML = appointmentsTbl.innerHTML+tbRow;
/* if (item.status.text==='İptal'){
    item.status.textcolor='#B00D0D';
}
else if (item.status.text==='Tamamlandı'){
    item.status.textcolor='#399E1A';
}
else {
    item.status.textcolor='#13C5DD';
}*/
    }
    function cancelAppointmentEvt(evt){

        var cancelAppointmentBtn = document.getElementById("cancelAppointmentBtn"+evt.currentTarget.param);
        if(cancelAppointmentBtn.classList.contains("btn-outline-dark")){
            alert('Zaten iptal edilmiştir.');
            return;
        }
        fetch('/api/appointments/'+evt.currentTarget.param, {
            method: 'PUT'
        })
            .then(window.location.href ="/appointments")

            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
        return false;

    }

    function cancelAppointment(evt){

        var cancelAppointmentBtn = document.getElementById("cancelAppointmentBtn");

        fetch('/api/appointments/'+evt.currentTarget.param, {
            method: 'PUT'
        })
            .then(window.location.href ="/appointmentsfordoctor")

            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
        return false;

    }
    function okAppointment(evt){
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        var prescriptionArea = document.getElementById("prescriptionArea");
        var reportArea = document.getElementById("reportArea");
        const  contentBody = JSON.stringify({appointmentId : urlParams.get('id'),  prescriptionContent : prescriptionArea.value,
            reportContent : reportArea.value} );

        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: contentBody
        };
        fetch('/api/appointments/', requestOptions);

        window.location.href ="/appointmentsfordoctor";


        return false;

    }



    function redirectAppointment(evt){
        window.location.href ="/appointmentactivity?id="+evt.currentTarget.param;
    }

    function  addAppointment(){
        var doctorsSelect = document.getElementById("doctorsSelect");
        var appointmentDate = document.getElementById("appointmentDate");
        var appointmentTime = document.getElementById("appointmentTime");
        const appointmentDateRequest = new Date(appointmentDate.value + ' ' +appointmentTime.value);

        const  contentBody = JSON.stringify({patientId : getCookie('userID') ,  doctorId : doctorsSelect.value,
            appointmentTime : appointmentDateRequest} );

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: contentBody
        };
        fetch('/api/appointments/add', requestOptions);

        window.location.href ="/appointments";
        return false;
    }

    function  addPolyclinicsOption(item){
        var polyclinicsSelect = document.getElementById("polyclinicsSelect");
        var option = document.createElement("option");
        option.text =  item.name;
        option.value = item.id;
        polyclinicsSelect.add(option);
    }

    function onChangePolyclinicSelect(){
        var polyclinicsSelect = document.getElementById("polyclinicsSelect");
        fetch('/api/doctors/getByPolyclinic?polyclinicID='+polyclinicsSelect.value, {
            method: 'GET'
        })
            .then(response => response.json())
            .then(data => {
                if (data.length > 0) {
                    var selectobject = document.getElementById("doctorsSelect");
                    for (var i=0; i<selectobject.length; i++) {
                        if (selectobject.options[i].value)
                            selectobject.remove(i);
                    }
                    selectobject.disabled = false;
                    data.forEach(addDoctorsOption);
                }
            })
            .catch(error => {
                // Hata durumunda yapılacak işlemler
            });
    }



    function  addDoctorsOption(item){
        var polyclinicsSelect = document.getElementById("doctorsSelect");
        var option = document.createElement("option");
        option.text =  item.name +  " " +  item.surName ;
        option.value = item.id;
        polyclinicsSelect.add(option);
    }

    function setCookie(paramName,paramValue) {
        document.cookie =  paramName+'='+paramValue;
    }

    function getCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for(var i=0;i < ca.length;i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    }

    if(getCookie('username')){
        const  navBar = document.getElementById("navbar-nav");
        const  patientLink = document.createElement("a");

        patientLink.classList.add('nav-item', 'nav-link' ,'patientLink');

        const  spanWelcome = document.createElement("span");
        spanWelcome.innerText = 'Hoşgeldin ';

        patientLink.appendChild(spanWelcome);

        const  spanPatient = document.createElement("span");
        spanPatient.innerText = getCookie('name') + ' '+getCookie('surname') ;
        spanPatient.style.color='#13C5DD';

        patientLink.appendChild(spanPatient);
        if(navBar){
            navBar.appendChild(patientLink);
        }
    }

    if(document.getElementById("loginPatient")){
        document.getElementById("loginPatient").addEventListener("click", loginPatient);
    }

    if(document.getElementById("loginDoctor")){
        document.getElementById("loginDoctor").addEventListener("click", loginDoctor);
    }

    function loginPatient() {
        var enteredUsername = document.getElementById("username").value;
        var enteredPassword = document.getElementById("password").value;
        eraseCookie();
        // Kullanıcı adı ve şifre kontrolü
        fetch('/api/patients/getAll')
            .then(response => response.json())
            .then(patients => {
                const foundPatient = patients.find(patient => patient.username === enteredUsername && patient.password === enteredPassword);
                if (foundPatient) {
                    // Doğru ise loggedInPage.html sayfasına yönlendir
                    setCookie('name',foundPatient.name);
                    setCookie('surname',foundPatient.surname);
                    setCookie('username',foundPatient.username);
                    setCookie('userID',foundPatient.id);
                    window.location.href = "loggedInPagePatient?username=" + enteredUsername;
                } else {
                    setCookie(enteredUsername);
                    // Yanlış ise aynı sayfada kal ve hata mesajını göster
                    alert("Kullanıcı adı veya şifre hatalı! Tekrar Deneyiniz!");
                }
            })
            .catch(error => {
                console.error("Hata oluştu:", error);
                alert("Kullanıcı adı veya şifre hatalı. Lütfen tekrar deneyiniz!");
            });
        window.onload = function() {
            // URL'deki parametreleri al
            const params = new URLSearchParams(window.location.search);
            const username = params.get('username');

            // Kullanıcı adını sayfada görüntüle
            document.getElementById('usernameDisplay').textContent = username;
        };
    }
    function loginDoctor() {
        var enteredUsername = document.getElementById("username").value;
        var enteredPassword = document.getElementById("password").value;
        eraseCookie();
        // Kullanıcı adı ve şifre kontrolü
        fetch('/api/doctors/login/'+enteredUsername+'/'+enteredPassword)
            .then(response => response.json())
            .then(doctor => {
                if (doctor) {
                    // Doğru ise loggedInPage.html sayfasına yönlendir
                    setCookie('name',doctor.name);
                    setCookie('surName',doctor.surname);
                    setCookie('doctorID',doctor.id);
                    window.location.href = "loggedInPageDoctor";
                } else {
                    // Yanlış ise aynı sayfada kal ve hata mesajını göster
                    alert("Kullanıcı adı veya şifre hatalı! Tekrar Deneyiniz!");
                }
            })
            .catch(error => {
                console.error("Hata oluştu:", error);
                alert("Bir hata oluştu. Lütfen tekrar deneyiniz!");
            });
        window.onload = function() {
            // URL'deki parametreleri al
            const params = new URLSearchParams(window.location.search);
            const username = params.get('username');

            // Kullanıcı adını sayfada görüntüle
            document.getElementById('usernameDisplay').textContent = username;
        };
    }

    function eraseCookie() {
        document.cookie = 'name=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
        document.cookie = 'surname=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
        document.cookie = 'username=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
        document.cookie = 'userID=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    }
})(jQuery);

