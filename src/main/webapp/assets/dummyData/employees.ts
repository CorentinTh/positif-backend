import {Employee, Experience, Role, User, Voice} from "../../app/_models";


// fetch('https://randomuser.me/api/?nat=fr&results=50')
//   .then(data => data.json())
//   .then(json => {
//     console.log(json.results.reduce((acc, user) => {
//
//       const voice = user.gender == 'male' ? 'Voice.MASCULINE' : 'Voice.FEMININE';
//       const experience = Math.random() > 0.5 ? 'Experience.SENIOR' : 'Experience.JUNIOR';
//
//       // acc += `PersonDao.persist(new Employee(${voice}, ${experience}, "${user.email}", "${user.name.first}", "${user.name.last}", "${gender}", "${user.login.password}", Date.from( Instant.parse("${user.dob.date}"))));\n`
//
//       acc += `
//   {
//     id: ${Math.floor(Math.random()*1000)},
//     password: '${user.login.password}',
//     firstname: '${user.name.first}',
//     lastname: '${user.name.last}',
//     email: '${user.email}',
//     experience: ${experience},
//     voice: ${voice},
//     role: Role.Employee,
//     gender: '${user.gender.toUpperCase().charAt(0)}',
//     birthDate: new Date('${user.dob.date}')
//   },`;
//
//       return acc;
//     }, ''));
//   });


const employees: Employee[] = [
  {
    id: 363,
    password: 'admin',
    firstname: 'Corentin',
    lastname: 'Thomasset',
    email: 'admin@positif.fr',
    role: Role.Employee,
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    gender: 'F',
    birthDate: new Date('1969-07-26T00:40:21Z')
  },
  {
    id: 585,
    password: 'goofy',
    firstname: 'luca',
    lastname: 'brun',
    email: 'luca.brun@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1955-08-16T14:26:14Z')
  },
  {
    id: 18,
    password: 'nadine',
    firstname: 'elise',
    lastname: 'gerard',
    email: 'elise.gerard@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1961-01-25T21:52:52Z')
  },
  {
    id: 843,
    password: 'phoenix1',
    firstname: 'léane',
    lastname: 'gerard',
    email: 'léane.gerard@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1974-12-25T15:37:54Z')
  },
  {
    id: 565,
    password: 'nana',
    firstname: 'owen',
    lastname: 'nicolas',
    email: 'owen.nicolas@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1960-11-17T05:57:46Z')
  },
  {
    id: 394,
    password: '1919',
    firstname: 'bérénice',
    lastname: 'gonzalez',
    email: 'bérénice.gonzalez@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1946-11-21T12:29:30Z')
  },
  {
    id: 992,
    password: 'november',
    firstname: 'lyna',
    lastname: 'lemoine',
    email: 'lyna.lemoine@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1974-11-02T15:26:37Z')
  },
  {
    id: 73,
    password: 'stonecol',
    firstname: 'alix',
    lastname: 'leroy',
    email: 'alix.leroy@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1966-06-21T11:12:21Z')
  },
  {
    id: 359,
    password: 'groovy',
    firstname: 'axelle',
    lastname: 'caron',
    email: 'axelle.caron@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1967-07-08T19:44:01Z')
  },
  {
    id: 471,
    password: '3232',
    firstname: 'mathis',
    lastname: 'mathieu',
    email: 'mathis.mathieu@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1983-07-12T15:40:11Z')
  },
  {
    id: 228,
    password: 'disco',
    firstname: 'lana',
    lastname: 'guerin',
    email: 'lana.guerin@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1983-02-11T17:17:51Z')
  },
  {
    id: 388,
    password: 'lobster',
    firstname: 'noam',
    lastname: 'olivier',
    email: 'noam.olivier@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1988-12-15T15:34:11Z')
  },
  {
    id: 645,
    password: 'rabbit',
    firstname: 'célian',
    lastname: 'deschamps',
    email: 'célian.deschamps@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1956-12-05T10:40:34Z')
  },
  {
    id: 400,
    password: '0101',
    firstname: 'léo',
    lastname: 'jean',
    email: 'léo.jean@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1959-02-18T06:15:55Z')
  },
  {
    id: 295,
    password: 'jupiter1',
    firstname: 'owen',
    lastname: 'lopez',
    email: 'owen.lopez@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1957-12-04T17:23:37Z')
  },
  {
    id: 342,
    password: 'chun',
    firstname: 'soren',
    lastname: 'brunet',
    email: 'soren.brunet@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1997-02-23T03:28:48Z')
  },
  {
    id: 578,
    password: 'stephanie',
    firstname: 'noélie',
    lastname: 'sanchez',
    email: 'noélie.sanchez@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1984-01-13T19:58:16Z')
  },
  {
    id: 840,
    password: 'zoom',
    firstname: 'damien',
    lastname: 'fournier',
    email: 'damien.fournier@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1973-09-27T09:58:38Z')
  },
  {
    id: 657,
    password: 'zack',
    firstname: 'eva',
    lastname: 'clement',
    email: 'eva.clement@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1956-04-15T23:01:10Z')
  },
  {
    id: 682,
    password: 'mankind',
    firstname: 'lyna',
    lastname: 'morel',
    email: 'lyna.morel@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1967-06-06T10:00:39Z')
  },
  {
    id: 652,
    password: 'hello1',
    firstname: 'sélène',
    lastname: 'morel',
    email: 'sélène.morel@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1973-07-09T11:52:39Z')
  },
  {
    id: 385,
    password: 'teaser',
    firstname: 'tessa',
    lastname: 'arnaud',
    email: 'tessa.arnaud@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1980-02-14T05:35:14Z')
  },
  {
    id: 485,
    password: 'pathfind',
    firstname: 'maélie',
    lastname: 'michel',
    email: 'maélie.michel@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1960-08-18T14:19:42Z')
  },
  {
    id: 75,
    password: 'cruise',
    firstname: 'eline',
    lastname: 'perez',
    email: 'eline.perez@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1988-09-05T12:31:01Z')
  },
  {
    id: 568,
    password: 'killbill',
    firstname: 'garance',
    lastname: 'dufour',
    email: 'garance.dufour@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1996-01-14T11:17:07Z')
  },
  {
    id: 920,
    password: 'pass',
    firstname: 'hadrien',
    lastname: 'roger',
    email: 'hadrien.roger@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1976-08-27T21:53:32Z')
  },
  {
    id: 204,
    password: 'windows1',
    firstname: 'elisa',
    lastname: 'adam',
    email: 'elisa.adam@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1965-10-23T17:37:44Z')
  },
  {
    id: 185,
    password: 'scooter1',
    firstname: 'rayan',
    lastname: 'lopez',
    email: 'rayan.lopez@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1964-12-27T01:18:57Z')
  },
  {
    id: 641,
    password: '1018',
    firstname: 'louanne',
    lastname: 'lemaire',
    email: 'louanne.lemaire@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1989-03-29T12:47:58Z')
  },
  {
    id: 330,
    password: 'newness',
    firstname: 'ugo',
    lastname: 'rousseau',
    email: 'ugo.rousseau@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1953-05-24T21:06:52Z')
  },
  {
    id: 657,
    password: 'openup',
    firstname: 'matthieu',
    lastname: 'martin',
    email: 'matthieu.martin@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1957-07-11T06:51:30Z')
  },
  {
    id: 777,
    password: 'pppp',
    firstname: 'mathias',
    lastname: 'gaillard',
    email: 'mathias.gaillard@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1989-12-31T04:17:34Z')
  },
  {
    id: 106,
    password: '12345a',
    firstname: 'tess',
    lastname: 'roger',
    email: 'tess.roger@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1977-03-06T17:14:11Z')
  },
  {
    id: 881,
    password: 'hornet',
    firstname: 'alicia',
    lastname: 'durand',
    email: 'alicia.durand@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1983-03-16T14:14:47Z')
  },
  {
    id: 711,
    password: 'kuai',
    firstname: 'lucy',
    lastname: 'lambert',
    email: 'lucy.lambert@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1974-01-18T16:44:43Z')
  },
  {
    id: 261,
    password: 'rusty2',
    firstname: 'rayan',
    lastname: 'renaud',
    email: 'rayan.renaud@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1995-04-08T23:43:45Z')
  },
  {
    id: 821,
    password: 'bruce',
    firstname: 'alexia',
    lastname: 'leclerc',
    email: 'alexia.leclerc@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1965-09-09T14:36:56Z')
  },
  {
    id: 797,
    password: 'cosworth',
    firstname: 'gabriel',
    lastname: 'deschamps',
    email: 'gabriel.deschamps@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1978-06-23T09:24:03Z')
  },
  {
    id: 268,
    password: '5454',
    firstname: 'roméo',
    lastname: 'dumas',
    email: 'roméo.dumas@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1995-05-19T18:32:57Z')
  },
  {
    id: 999,
    password: 'kingdom',
    firstname: 'lou',
    lastname: 'martin',
    email: 'lou.martin@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1964-09-07T21:40:37Z')
  },
  {
    id: 635,
    password: 'sadie1',
    firstname: 'louna',
    lastname: 'duval',
    email: 'louna.duval@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1979-03-31T10:25:06Z')
  },
  {
    id: 833,
    password: 'jetta',
    firstname: 'louanne',
    lastname: 'da silva',
    email: 'louanne.dasilva@example.com',
    experience: Experience.SENIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1958-01-21T08:30:27Z')
  },
  {
    id: 955,
    password: 'lucy',
    firstname: 'lohan',
    lastname: 'dumont',
    email: 'lohan.dumont@example.com',
    experience: Experience.SENIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1953-07-20T19:33:47Z')
  },
  {
    id: 483,
    password: 'theman',
    firstname: 'charlie',
    lastname: 'olivier',
    email: 'charlie.olivier@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1960-02-09T20:57:30Z')
  },
  {
    id: 205,
    password: 'helena',
    firstname: 'dylan',
    lastname: 'moulin',
    email: 'dylan.moulin@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1986-10-27T02:08:41Z')
  },
  {
    id: 53,
    password: 'albatros',
    firstname: 'malone',
    lastname: 'schmitt',
    email: 'malone.schmitt@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1995-01-27T03:16:27Z')
  },
  {
    id: 746,
    password: 'nasty',
    firstname: 'fabio',
    lastname: 'blanc',
    email: 'fabio.blanc@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1963-12-29T16:02:38Z')
  },
  {
    id: 263,
    password: 'kestrel',
    firstname: 'maëly',
    lastname: 'andre',
    email: 'maëly.andre@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1987-04-24T22:13:47Z')
  },
  {
    id: 329,
    password: 'patriot',
    firstname: 'enola',
    lastname: 'muller',
    email: 'enola.muller@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.FEMININE,
    role: Role.Employee,
    gender: 'F',
    birthDate: new Date('1950-10-14T02:08:38Z')
  },
  {
    id: 766,
    password: 'buckeye',
    firstname: 'mahé',
    lastname: 'garcia',
    email: 'mahé.garcia@example.com',
    experience: Experience.JUNIOR,
    voice: Voice.MASCULINE,
    role: Role.Employee,
    gender: 'M',
    birthDate: new Date('1983-02-06T20:07:53Z')
  }
];

export {employees};

