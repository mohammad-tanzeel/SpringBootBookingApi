# SpringBootBookingApi
Booking Rest Api

MYSQL Script
CREATE DATABASE tour_travel;

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) NOT NULL,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `passengers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `source`, `destination`, `start_date`, `end_date`, `passengers`) VALUES
(1, 'del', 'bom', '2019-11-14', '2019-11-21', 3),
(2, 'del', 'bom', '2019-11-14', '2019-11-21', 3),
(3, 'del', 'bom', '2019-11-14', '2019-11-21', 3),
(4, '', 'bom', '2019-11-14', '2019-11-21', 3),
(8, 'dd', 'ss', '2019-11-21', '2019-11-21', 3),
(11, 'ddss', 'sssaa', '2019-11-21', '2019-11-21', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--