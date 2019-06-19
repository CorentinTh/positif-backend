import {Client, Role, User} from "../../app/_models";


// fetch('https://randomuser.me/api/?nat=fr&results=50')
//   .then(data => data.json())
//   .then(json => {
//     console.log(json.results.reduce((acc, user) => {
//
//       const voice = user.gender == 'male' ? 'VoiceType.MASCULINE' : 'VoiceType.FEMININE';
//       const experience = Math.random() > 0.5 ? 'ExperienceType.SENIOR' : 'ExperienceType.JUNIOR';
//       const gender = user.gender == 'male' ? 'M' : 'F';
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
//     role: Role.Client,
//     address: {
//       lon: ${user.location.coordinates.longitude},
//       lat: ${user.location.coordinates.latitude},
//       string:"${user.location.street + ' ' + user.location.city + ' ' + user.location.state}"
//     },
//     phone:"${user.phone.replace('-', '')}",
//     gender: '${user.gender.toUpperCase().charAt(0)}',
//     birthDate: new Date('${user.dob.date}')
//   },`;
//
//       return acc;
//     }, ''));
//   });


const clients: Client[] = [
  {
    id: 125,
    password: 'user',
    firstname: 'Corentin',
    lastname: 'Thomasset',
    email: 'user@positif.fr',
    role: Role.Client,
    address: {
      lon: -79.1827,
      lat: -2.6284,
      string:"145 rue du village limoges charente-maritime"
    },
    phone:"0472028886",
    gender: 'F',
    birthDate: new Date('1969-07-26T00:40:21Z')
  },
  {
    id: 751,
    password: 'keith',
    firstname: 'norah',
    lastname: 'rey',
    email: 'norah.rey@example.com',
    role: Role.Client,
    address: {
      lon: 104.7710,
      lat: -46.7753,
      string:"3981 rue de l'abbé-migne rouen indre-et-loire"
    },
    phone:"0445489863",
    gender: 'F',
    birthDate: new Date('1970-12-14T09:33:20Z')
  },
  {
    id: 943,
    password: 'coucou',
    firstname: 'logan',
    lastname: 'philippe',
    email: 'logan.philippe@example.com',
    role: Role.Client,
    address: {
      lon: -66.8211,
      lat: 27.7913,
      string:"8018 rue des abbesses angers aube"
    },
    phone:"0363135140",
    gender: 'M',
    birthDate: new Date('1968-07-24T20:32:04Z')
  },
  {
    id: 264,
    password: 'arthur',
    firstname: 'lia',
    lastname: 'jean',
    email: 'lia.jean@example.com',
    role: Role.Client,
    address: {
      lon: -111.8292,
      lat: 25.4555,
      string:"5059 avenue de la libération montpellier vaucluse"
    },
    phone:"0109718381",
    gender: 'F',
    birthDate: new Date('1960-02-07T16:31:15Z')
  },
  {
    id: 643,
    password: 'masamune',
    firstname: 'line',
    lastname: 'adam',
    email: 'line.adam@example.com',
    role: Role.Client,
    address: {
      lon: 107.4562,
      lat: 28.2916,
      string:"3216 rue du dauphiné saint-étienne haute-marne"
    },
    phone:"0381891060",
    gender: 'F',
    birthDate: new Date('1967-03-14T06:26:00Z')
  },
  {
    id: 548,
    password: 'gotribe',
    firstname: 'coline',
    lastname: 'lambert',
    email: 'coline.lambert@example.com',
    role: Role.Client,
    address: {
      lon: 148.6781,
      lat: -85.9140,
      string:"7890 rue du 8 mai 1945 grenoble gard"
    },
    phone:"0558102116",
    gender: 'F',
    birthDate: new Date('1974-03-09T18:54:59Z')
  },
  {
    id: 245,
    password: 'gregor',
    firstname: 'enora',
    lastname: 'lemoine',
    email: 'enora.lemoine@example.com',
    role: Role.Client,
    address: {
      lon: 128.7426,
      lat: 56.2632,
      string:"7876 rue des abbesses paris indre-et-loire"
    },
    phone:"0565892059",
    gender: 'F',
    birthDate: new Date('1979-03-10T13:54:43Z')
  },
  {
    id: 797,
    password: 'crack',
    firstname: 'julien',
    lastname: 'roussel',
    email: 'julien.roussel@example.com',
    role: Role.Client,
    address: {
      lon: -138.5296,
      lat: -69.9384,
      string:"4627 rue saint-georges aulnay-sous-bois lot"
    },
    phone:"0455999204",
    gender: 'M',
    birthDate: new Date('1949-10-12T09:20:32Z')
  },
  {
    id: 426,
    password: 'camper',
    firstname: 'sacha',
    lastname: 'aubert',
    email: 'sacha.aubert@example.com',
    role: Role.Client,
    address: {
      lon: 132.5126,
      lat: -11.4315,
      string:"2670 rue gasparin nanterre corrèze"
    },
    phone:"0321235465",
    gender: 'M',
    birthDate: new Date('1981-02-07T00:22:21Z')
  },
  {
    id: 338,
    password: 'older',
    firstname: 'théodore',
    lastname: 'blanc',
    email: 'théodore.blanc@example.com',
    role: Role.Client,
    address: {
      lon: 177.5611,
      lat: -20.3559,
      string:"7680 rue du village nîmes loiret"
    },
    phone:"0398417322",
    gender: 'M',
    birthDate: new Date('1980-07-07T13:57:11Z')
  },
  {
    id: 903,
    password: 'taichi',
    firstname: 'hanaé',
    lastname: 'lefebvre',
    email: 'hanaé.lefebvre@example.com',
    role: Role.Client,
    address: {
      lon: 172.4773,
      lat: 12.6501,
      string:"170 rue du cardinal-gerlier paris haute-saône"
    },
    phone:"0517449371",
    gender: 'F',
    birthDate: new Date('1979-08-04T01:07:23Z')
  },
  {
    id: 678,
    password: 'jimmys',
    firstname: 'johan',
    lastname: 'joly',
    email: 'johan.joly@example.com',
    role: Role.Client,
    address: {
      lon: 172.5510,
      lat: 0.4352,
      string:"4352 rue cyrus-hugues nîmes seine-saint-denis"
    },
    phone:"0457644774",
    gender: 'M',
    birthDate: new Date('1973-02-17T04:59:03Z')
  },
  {
    id: 522,
    password: 'flowers',
    firstname: 'livia',
    lastname: 'giraud',
    email: 'livia.giraud@example.com',
    role: Role.Client,
    address: {
      lon: 75.9353,
      lat: 14.8133,
      string:"2089 rue saint-georges argenteuil marne"
    },
    phone:"0196339883",
    gender: 'F',
    birthDate: new Date('1971-10-07T08:43:58Z')
  },
  {
    id: 442,
    password: 'rusty',
    firstname: 'emmie',
    lastname: 'meunier',
    email: 'emmie.meunier@example.com',
    role: Role.Client,
    address: {
      lon: -103.8381,
      lat: -68.3740,
      string:"4773 rue duguesclin reims oise"
    },
    phone:"0329185012",
    gender: 'F',
    birthDate: new Date('1968-12-23T23:09:11Z')
  },
  {
    id: 591,
    password: 'playa',
    firstname: 'mathis',
    lastname: 'vidal',
    email: 'mathis.vidal@example.com',
    role: Role.Client,
    address: {
      lon: -52.1838,
      lat: 14.9000,
      string:"4999 boulevard de la duchère champigny-sur-marne loir-et-cher"
    },
    phone:"0459482991",
    gender: 'M',
    birthDate: new Date('1981-06-26T04:05:30Z')
  },
  {
    id: 540,
    password: 'nimrod',
    firstname: 'ava',
    lastname: 'thomas',
    email: 'ava.thomas@example.com',
    role: Role.Client,
    address: {
      lon: -11.0868,
      lat: 45.7316,
      string:"7345 rue de l'abbé-carton vitry-sur-seine bas-rhin"
    },
    phone:"0432288404",
    gender: 'F',
    birthDate: new Date('1995-09-10T03:08:03Z')
  },
  {
    id: 456,
    password: 'tekken',
    firstname: 'milo',
    lastname: 'olivier',
    email: 'milo.olivier@example.com',
    role: Role.Client,
    address: {
      lon: 58.1106,
      lat: 31.3251,
      string:"4251 rue de gerland fort-de-france yvelines"
    },
    phone:"0514108864",
    gender: 'M',
    birthDate: new Date('1968-12-19T05:58:38Z')
  },
  {
    id: 23,
    password: 'charlie',
    firstname: 'lyna',
    lastname: 'pierre',
    email: 'lyna.pierre@example.com',
    role: Role.Client,
    address: {
      lon: -14.2803,
      lat: -20.4700,
      string:"5864 avenue debourg strasbourg yonne"
    },
    phone:"0413469123",
    gender: 'F',
    birthDate: new Date('1973-10-29T20:09:46Z')
  },
  {
    id: 42,
    password: 'gate',
    firstname: 'amelia',
    lastname: 'hubert',
    email: 'amelia.hubert@example.com',
    role: Role.Client,
    address: {
      lon: -157.5615,
      lat: 68.3493,
      string:"6463 rue de l'abbé-rousselot marseille marne"
    },
    phone:"0264173587",
    gender: 'F',
    birthDate: new Date('1964-07-15T22:58:40Z')
  },
  {
    id: 790,
    password: 'handsome',
    firstname: 'anaëlle',
    lastname: 'garnier',
    email: 'anaëlle.garnier@example.com',
    role: Role.Client,
    address: {
      lon: -136.1107,
      lat: 72.5311,
      string:"4679 rue paul-duvivier clermont-ferrand ain"
    },
    phone:"0351468476",
    gender: 'F',
    birthDate: new Date('1946-10-02T17:39:24Z')
  },
  {
    id: 869,
    password: 'mullet',
    firstname: 'valentine',
    lastname: 'francois',
    email: 'valentine.francois@example.com',
    role: Role.Client,
    address: {
      lon: 179.1336,
      lat: 27.9729,
      string:"2401 place du 8 février 1962 metz morbihan"
    },
    phone:"0527137369",
    gender: 'F',
    birthDate: new Date('1955-07-23T05:19:52Z')
  },
  {
    id: 836,
    password: 'michigan',
    firstname: 'timothe',
    lastname: 'leclerc',
    email: 'timothe.leclerc@example.com',
    role: Role.Client,
    address: {
      lon: 127.1412,
      lat: -59.6195,
      string:"129 rue de la fontaine colombes eure"
    },
    phone:"0215131223",
    gender: 'M',
    birthDate: new Date('1948-05-17T05:39:18Z')
  },
  {
    id: 832,
    password: 'dotcom',
    firstname: 'laly',
    lastname: 'giraud',
    email: 'laly.giraud@example.com',
    role: Role.Client,
    address: {
      lon: 91.2866,
      lat: 5.1096,
      string:"7879 rue de l'abbé-groult fort-de-france guadeloupe"
    },
    phone:"0447853184",
    gender: 'F',
    birthDate: new Date('1965-07-21T01:20:44Z')
  },
  {
    id: 778,
    password: 'onetwo',
    firstname: 'milan',
    lastname: 'martin',
    email: 'milan.martin@example.com',
    role: Role.Client,
    address: {
      lon: -19.6595,
      lat: 44.6943,
      string:"6434 rue du village versailles guyane"
    },
    phone:"0430506416",
    gender: 'M',
    birthDate: new Date('1947-02-24T06:53:52Z')
  },
  {
    id: 544,
    password: 'hummer',
    firstname: 'tony',
    lastname: 'roussel',
    email: 'tony.roussel@example.com',
    role: Role.Client,
    address: {
      lon: 82.2994,
      lat: 83.9214,
      string:"4040 rue barrier toulouse charente"
    },
    phone:"0477185365",
    gender: 'M',
    birthDate: new Date('1950-07-15T02:00:29Z')
  },
  {
    id: 972,
    password: 'knockers',
    firstname: 'liam',
    lastname: 'bonnet',
    email: 'liam.bonnet@example.com',
    role: Role.Client,
    address: {
      lon: -76.4390,
      lat: 48.9770,
      string:"9180 rue baraban nanterre nièvre"
    },
    phone:"0199046128",
    gender: 'M',
    birthDate: new Date('1972-02-11T05:57:24Z')
  },
  {
    id: 374,
    password: '0101',
    firstname: 'mathieu',
    lastname: 'bernard',
    email: 'mathieu.bernard@example.com',
    role: Role.Client,
    address: {
      lon: -109.5396,
      lat: -17.7355,
      string:"5963 grande rue champigny-sur-marne eure"
    },
    phone:"0242890565",
    gender: 'M',
    birthDate: new Date('1988-06-17T06:41:23Z')
  },
  {
    id: 209,
    password: 'bigdawg',
    firstname: 'kiara',
    lastname: 'berger',
    email: 'kiara.berger@example.com',
    role: Role.Client,
    address: {
      lon: 129.1061,
      lat: 82.7370,
      string:"1566 rue barrème limoges vendée"
    },
    phone:"0573914688",
    gender: 'F',
    birthDate: new Date('1980-07-27T06:57:41Z')
  },
  {
    id: 200,
    password: 'bradford',
    firstname: 'lana',
    lastname: 'legrand',
    email: 'lana.legrand@example.com',
    role: Role.Client,
    address: {
      lon: 149.5252,
      lat: 53.7951,
      string:"4375 avenue du château orléans ain"
    },
    phone:"0231851551",
    gender: 'F',
    birthDate: new Date('1986-12-11T19:27:23Z')
  },
  {
    id: 189,
    password: 'brodie',
    firstname: 'lilly',
    lastname: 'vidal',
    email: 'lilly.vidal@example.com',
    role: Role.Client,
    address: {
      lon: -62.0327,
      lat: 51.7258,
      string:"3064 rue de l'abbaye colombes nord"
    },
    phone:"0539827418",
    gender: 'F',
    birthDate: new Date('1988-01-13T02:00:54Z')
  },
  {
    id: 498,
    password: 'porn',
    firstname: 'auguste',
    lastname: 'michel',
    email: 'auguste.michel@example.com',
    role: Role.Client,
    address: {
      lon: -10.4477,
      lat: -52.7206,
      string:"8275 rue courbet courbevoie ain"
    },
    phone:"0577109025",
    gender: 'M',
    birthDate: new Date('1960-01-21T13:54:12Z')
  },
  {
    id: 483,
    password: 'hopeless',
    firstname: 'ugo',
    lastname: 'rey',
    email: 'ugo.rey@example.com',
    role: Role.Client,
    address: {
      lon: -109.5154,
      lat: 87.6917,
      string:"5868 rue de la fontaine vitry-sur-seine hautes-pyrénées"
    },
    phone:"0452683987",
    gender: 'M',
    birthDate: new Date('1949-04-24T05:09:29Z')
  },
  {
    id: 936,
    password: 'avatar',
    firstname: 'norah',
    lastname: 'durand',
    email: 'norah.durand@example.com',
    role: Role.Client,
    address: {
      lon: 6.0923,
      lat: -52.8352,
      string:"2758 montée du chemin-neuf le mans hauts-de-seine"
    },
    phone:"0140591658",
    gender: 'F',
    birthDate: new Date('1975-07-08T19:48:16Z')
  },
  {
    id: 383,
    password: 'stud',
    firstname: 'victoire',
    lastname: 'pierre',
    email: 'victoire.pierre@example.com',
    role: Role.Client,
    address: {
      lon: 27.2119,
      lat: 1.1283,
      string:"1751 rue duquesne nanterre val-d'oise"
    },
    phone:"0338731677",
    gender: 'F',
    birthDate: new Date('1945-05-02T08:08:36Z')
  },
  {
    id: 995,
    password: 'cigars',
    firstname: 'valentine',
    lastname: 'rousseau',
    email: 'valentine.rousseau@example.com',
    role: Role.Client,
    address: {
      lon: 42.0864,
      lat: 40.5256,
      string:"8824 place du 8 février 1962 aubervilliers loire"
    },
    phone:"0491857409",
    gender: 'F',
    birthDate: new Date('1960-09-27T03:42:26Z')
  },
  {
    id: 92,
    password: 'kkkkkk',
    firstname: 'romain',
    lastname: 'durand',
    email: 'romain.durand@example.com',
    role: Role.Client,
    address: {
      lon: 76.9854,
      lat: 29.3079,
      string:"2264 rue du moulin bordeaux marne"
    },
    phone:"0119366847",
    gender: 'M',
    birthDate: new Date('1978-06-14T07:44:41Z')
  },
  {
    id: 636,
    password: '8888',
    firstname: 'gabin',
    lastname: 'andre',
    email: 'gabin.andre@example.com',
    role: Role.Client,
    address: {
      lon: 142.2018,
      lat: -75.6083,
      string:"8094 rue de la charité avignon allier"
    },
    phone:"0548468242",
    gender: 'M',
    birthDate: new Date('1959-09-11T09:47:29Z')
  },
  {
    id: 501,
    password: 'taylor1',
    firstname: 'lise',
    lastname: 'aubert',
    email: 'lise.aubert@example.com',
    role: Role.Client,
    address: {
      lon: -32.0921,
      lat: 24.1289,
      string:"1176 rue baraban vitry-sur-seine bouches-du-rhône"
    },
    phone:"0498459109",
    gender: 'F',
    birthDate: new Date('1963-03-22T08:09:08Z')
  },
  {
    id: 351,
    password: 'browns',
    firstname: 'daphné',
    lastname: 'meyer',
    email: 'daphné.meyer@example.com',
    role: Role.Client,
    address: {
      lon: -171.4092,
      lat: -10.0184,
      string:"9407 rue pierre-delore mulhouse loiret"
    },
    phone:"0399647320",
    gender: 'F',
    birthDate: new Date('1964-11-21T16:17:45Z')
  },
  {
    id: 761,
    password: 'kellie',
    firstname: 'damien',
    lastname: 'brun',
    email: 'damien.brun@example.com',
    role: Role.Client,
    address: {
      lon: -109.5076,
      lat: -14.2417,
      string:"1608 rue de l'abbaye dijon hauts-de-seine"
    },
    phone:"0375125557",
    gender: 'M',
    birthDate: new Date('1985-10-02T14:24:08Z')
  },
  {
    id: 626,
    password: 'line',
    firstname: 'clara',
    lastname: 'michel',
    email: 'clara.michel@example.com',
    role: Role.Client,
    address: {
      lon: 157.7605,
      lat: -84.5039,
      string:"3109 rue principale le mans doubs"
    },
    phone:"0292177605",
    gender: 'F',
    birthDate: new Date('1957-01-01T06:54:49Z')
  },
  {
    id: 79,
    password: 'puppydog',
    firstname: 'livia',
    lastname: 'morin',
    email: 'livia.morin@example.com',
    role: Role.Client,
    address: {
      lon: -94.0576,
      lat: -59.3768,
      string:"6394 rue de l'abbé-gillet saint-pierre eure-et-loir"
    },
    phone:"0341076166",
    gender: 'F',
    birthDate: new Date('1987-02-10T23:28:47Z')
  },
  {
    id: 851,
    password: 'sally',
    firstname: 'edouard',
    lastname: 'leroux',
    email: 'edouard.leroux@example.com',
    role: Role.Client,
    address: {
      lon: -127.3537,
      lat: 12.8138,
      string:"4553 rue de l'abbé-soulange-bodin saint-denis moselle"
    },
    phone:"0349497529",
    gender: 'M',
    birthDate: new Date('1976-01-04T15:38:05Z')
  },
  {
    id: 890,
    password: '1269',
    firstname: 'loris',
    lastname: 'guillot',
    email: 'loris.guillot@example.com',
    role: Role.Client,
    address: {
      lon: -42.6971,
      lat: 12.1921,
      string:"9402 place des 44 enfants d'izieu toulouse pyrénées-atlantiques"
    },
    phone:"0522380256",
    gender: 'M',
    birthDate: new Date('1945-06-10T05:56:46Z')
  },
  {
    id: 620,
    password: 'abcd',
    firstname: 'aymeric',
    lastname: 'lucas',
    email: 'aymeric.lucas@example.com',
    role: Role.Client,
    address: {
      lon: 150.5734,
      lat: 39.0369,
      string:"3123 rue bossuet saint-étienne landes"
    },
    phone:"0370367492",
    gender: 'M',
    birthDate: new Date('1980-06-20T06:05:36Z')
  },
  {
    id: 821,
    password: 'tsunami',
    firstname: 'melvin',
    lastname: 'roger',
    email: 'melvin.roger@example.com',
    role: Role.Client,
    address: {
      lon: -127.7186,
      lat: 11.8965,
      string:"2880 place du 8 février 1962 lyon alpes-maritimes"
    },
    phone:"0110300975",
    gender: 'M',
    birthDate: new Date('1993-09-26T04:29:34Z')
  },
  {
    id: 557,
    password: 'elliott',
    firstname: 'aloïs',
    lastname: 'gautier',
    email: 'aloïs.gautier@example.com',
    role: Role.Client,
    address: {
      lon: -151.5323,
      lat: -54.2878,
      string:"9698 avenue de la république pau ille-et-vilaine"
    },
    phone:"0372848420",
    gender: 'M',
    birthDate: new Date('1944-11-25T05:29:19Z')
  },
  {
    id: 276,
    password: 'connect',
    firstname: 'léane',
    lastname: 'petit',
    email: 'léane.petit@example.com',
    role: Role.Client,
    address: {
      lon: 26.6660,
      lat: 56.8569,
      string:"8012 rue louis-garrand metz morbihan"
    },
    phone:"0281130006",
    gender: 'F',
    birthDate: new Date('1947-10-27T09:51:30Z')
  },
  {
    id: 69,
    password: 'manfred',
    firstname: 'stella',
    lastname: 'muller',
    email: 'stella.muller@example.com',
    role: Role.Client,
    address: {
      lon: 106.1151,
      lat: 46.1702,
      string:"5821 rue de l'abbé-grégoire marseille alpes-de-haute-provence"
    },
    phone:"0436575405",
    gender: 'F',
    birthDate: new Date('1945-07-30T05:02:50Z')
  },
  {
    id: 514,
    password: 'audio',
    firstname: 'maëline',
    lastname: 'renaud',
    email: 'maëline.renaud@example.com',
    role: Role.Client,
    address: {
      lon: -16.6106,
      lat: 88.3504,
      string:"4756 rue dumenge saint-denis eure"
    },
    phone:"0187918605",
    gender: 'F',
    birthDate: new Date('1980-05-05T19:29:24Z')
  },
  {
    id: 795,
    password: 'everest',
    firstname: 'lina',
    lastname: 'roux',
    email: 'lina.roux@example.com',
    role: Role.Client,
    address: {
      lon: -79.1827,
      lat: -2.6284,
      string:"145 rue du village limoges charente-maritime"
    },
    phone:"0472028886",
    gender: 'F',
    birthDate: new Date('1969-07-26T00:40:21Z')
  }
];

export {clients};

