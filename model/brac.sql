

--
-- Database: `ulab`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `GFID` varchar(20) NOT NULL,
  `NID` varchar(20) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `FATHER_NAME` varchar(50) DEFAULT NULL,
  `MOTHER_NAME` varchar(50) DEFAULT NULL,
  `SALARY` varchar(10) DEFAULT NULL,
  `SALARY_TYPE` varchar(50) DEFAULT NULL,
  `CONTACT` varchar(20) DEFAULT NULL,
  `HEIGHT` varchar(20) DEFAULT NULL,
  `EDUCATION` varchar(50) DEFAULT NULL,
  `EXPERIENCE` varchar(50) DEFAULT NULL,
  `GRAM_ADDRESS` varchar(50) DEFAULT NULL,
  `THANA_ADDRESS` varchar(50) DEFAULT NULL,
  `WARD_ADDRESS` varchar(50) DEFAULT NULL,
  `JILLA_ADDRESS` varchar(50) DEFAULT NULL,
  `POSTING` varchar(50) DEFAULT NULL,
  `REFERENCE` varchar(50) DEFAULT NULL,
  `REMARKS` varchar(50) DEFAULT NULL,
  `DESIGNATION` varchar(30) DEFAULT NULL,
  `JOINING` date DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `IMAGE` mediumblob DEFAULT NULL,
  `IDENTIFICATION` varchar(100) DEFAULT NULL,
  `ATTACHMENT` varchar(10) DEFAULT NULL,
  `MARITAL_STATUS` varchar(30) DEFAULT NULL,
  `SPOUSE_AGE` varchar(3) DEFAULT NULL,
  `CHILD_NAME_1` varchar(50) DEFAULT NULL,
  `CHILD_NAME_2` varchar(50) DEFAULT NULL,
  `CHILD_NAME_3` varchar(50) DEFAULT NULL,
  `CHILD_RELATION_1` varchar(70) DEFAULT NULL,
  `CHILD_RELATION_2` varchar(70) DEFAULT NULL,
  `CHILD_RELATION_3` varchar(70) DEFAULT NULL,
  `CHILD_AGE_1` varchar(3) DEFAULT NULL,
  `CHILD_AGE_2` varchar(3) DEFAULT NULL,
  `CHILD_AGE_3` varchar(3) DEFAULT NULL,
  `CURRENT_ADDRESS` varchar(100) DEFAULT NULL,
  `CHEST` varchar(5) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `BLOOD` varchar(5) DEFAULT NULL,
  `WEIGHT` varchar(5) DEFAULT NULL,
  `RELIGION` varchar(20) DEFAULT NULL,
  `SPOUSE` varchar(50) DEFAULT NULL,
  `SOURCE` varchar(15) DEFAULT NULL,
  `SOURCE_NAME` varchar(50) DEFAULT NULL,
  `SOURCE_ADDRESS` varchar(100) DEFAULT NULL,
  `SOURCE_CONTACT` varchar(15) DEFAULT NULL,
  `SOURCE_OCCUPATION` varchar(15) DEFAULT NULL,
  `SOURCE_RELATION` varchar(30) DEFAULT NULL,
  `EMERGENCY_NAME_1` varchar(50) DEFAULT NULL,
  `EMERGENCY_ADDRESS_1` varchar(100) DEFAULT NULL,
  `EMERGENCY_CONTACT_1` varchar(15) DEFAULT NULL,
  `EMERGENCY_OCCUPATION_1` varchar(15) DEFAULT NULL,
  `EMERGENCY_RELATION_1` varchar(15) DEFAULT NULL,
  `EMERGENCY_NAME_2` varchar(50) DEFAULT NULL,
  `EMERGENCY_ADDRESS_2` varchar(100) DEFAULT NULL,
  `EMERGENCY_CONTACT_2` varchar(15) DEFAULT NULL,
  `EMERGENCY_OCCUPATION_2` varchar(15) DEFAULT NULL,
  `EMERGENCY_RELATION_2` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--


CREATE TABLE `monthly_report` (
  `MONTH` varchar(20) DEFAULT NULL,
  `YEAR` varchar(20) DEFAULT NULL,
  `GFID` varchar(20) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `PAID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `monthly_report`
--

INSERT INTO `monthly_report` (`MONTH`, `YEAR`, `GFID`, `QUANTITY`, `AMOUNT`, `PAID`) VALUES
('SEPTEMBER', '2019', '322', 4, 2140, 1840),
('AUGUST', '2019', '322', 3, 4500, 3500),
('OCTOBER', '2019', '322', 1, 1500, 1200),
('NOVEMBER', '2019', '322', 2, 3300, -200),
('DECEMBER', '2019', '322', 2, 3620, 3620),
('SEPTEMBER', '2019', '122', 2, 610, 560),
('OCTOBER', '2019', '122', 1, 310, 310),
('OCTOBER', '2019', '17101089', 1, 1500, 1500),
('NOVEMBER', '2019', '1234', 1, 10, 10),
('APRIL', '2021', '1234', 1, 6320, 6320),
('APRIL', '2021', '2345', 1, 20, 20);

-- --------------------------------------------------------

CREATE TABLE `penalty` (
  `GFID` varchar(10) DEFAULT NULL,
  `PENALTY_DATE` date DEFAULT NULL,
  `INSPECTOR_GFID` varchar(10) DEFAULT NULL,
  `ZONE` varchar(20) DEFAULT NULL,
  `TIME` varchar(11) DEFAULT NULL,
  `GUARD_LOCATION` varchar(50) DEFAULT NULL,
  `CONDITION_STATE` varchar(1000) DEFAULT NULL,
  `REMARKS` varchar(1000) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `recieve_inventory` (
  `issue_DATE` date DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `QUATITY` int(11) DEFAULT NULL,
  `SERIAL` int(11) NOT NULL,
  `GFID` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recieve_inventory`

--
-- Table structure for table `set_penalty`
--

CREATE TABLE `set_penalty` (
  `sleep` int(11) DEFAULT NULL,
  `belt` int(11) DEFAULT NULL,
  `bashi` int(11) DEFAULT NULL,
  `dayitto` int(11) DEFAULT NULL,
  `dirty_dress` int(11) DEFAULT NULL,
  `no_dress` int(11) DEFAULT NULL,
  `iron` int(11) DEFAULT NULL,
  `absent` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `hair` int(11) DEFAULT NULL,
  `shave` int(11) DEFAULT NULL,
  `boot` int(11) DEFAULT NULL,
  `polish` int(11) DEFAULT NULL,
  `civil` int(11) DEFAULT NULL,
  `appulate` int(11) DEFAULT NULL,
  `nameplate` int(11) DEFAULT NULL,
  `identify` int(11) DEFAULT NULL,
  `shirt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`GFID`);

--
ALTER TABLE `recieve_inventory`
  ADD UNIQUE KEY `SERIAL` (`SERIAL`);

-- AUTO_INCREMENT for dumped tables
--
--
-- AUTO_INCREMENT for table `recieve_inventory`
--
ALTER TABLE `recieve_inventory`
  MODIFY `SERIAL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

