// Public Subnets

resource "aws_subnet" "sn-1a-public-xlb" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.96.0/24"
  availability_zone = "eu-central-1a"

  tags = {
    Name        = "habil-dev-1a-public-xlb"
    CostCenter  = "habil-dev-1a-public-xlb"
  }
}

resource "aws_subnet" "sn-1b-public-xlb" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.97.0/24"
  availability_zone = "eu-central-1b"

  tags = {
    Name        = "habil-dev-1b-public-xlb"
    CostCenter  = "habil-dev-1b-public-xlb"
  }
}

resource "aws_subnet" "sn-1c-public-xlb" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.98.0/24"
  availability_zone = "eu-central-1c"

  tags = {
    Name        = "habil-dev-1c-public-xlb"
    CostCenter  = "habil-dev-1c-public-xlb"
  }
}

// Private Generic Subnets

resource "aws_subnet" "sn-1a-private-generic" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.104.0/21"
  availability_zone = "eu-central-1a"

  tags = {
    Name        = "habil-dev-1a-private-generic"
    CostCenter  = "habil-dev-1a-private-generic"
  }
}

resource "aws_subnet" "sn-1b-private-generic" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.112.0/21"
  availability_zone = "eu-central-1b"

  tags = {
    Name        = "habil-dev-1b-private-generic"
    CostCenter  = "habil-dev-1b-private-generic"
  }
}

resource "aws_subnet" "sn-1c-private-generic" {
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.20.120.0/21"
  availability_zone = "eu-central-1c"

  tags = {
    Name        = "habil-dev-1c-private-generic"
    CostCenter  = "habil-dev-1c-private-generic"
  }
}




