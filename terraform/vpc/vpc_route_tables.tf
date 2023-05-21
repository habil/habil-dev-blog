// Public Route Table
resource "aws_route_table" "rt-1a-public-xlb" {

   route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gateway.id
  }

  tags = {
    Name = "habil-dev-1a-public-xlb-rt"
    CostCenter = "habil-dev-1a-public-xlb-rt"
  }

  vpc_id = aws_vpc.vpc.id
}

resource "aws_route_table" "rt-1b-public-xlb" {

   route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gateway.id
  }

  tags = {
    Name = "habil-dev-1b-public-xlb-rt"
    CostCenter = "habil-dev-1b-public-xlb-rt"
  }

  vpc_id = aws_vpc.vpc.id
}

resource "aws_route_table" "rt-1c-public-xlb" {

   route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gateway.id
  }

  tags = {
    Name = "habil-dev-1c-public-xlb-rt"
    CostCenter = "habil-dev-1c-public-xlb-rt"
  }

  vpc_id = aws_vpc.vpc.id
}

// Private Generic Route Table

resource "aws_route_table" "rt-1a-private-generic" {

  route {
    cidr_block     = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.nat-1a.id
  }

  tags = {
    Name = "habil-dev-1a-private-generic-rt"
    CostCenter = "habil-dev-1a-private-generic-rt"
  }

  vpc_id = aws_vpc.vpc.id
}

resource "aws_route_table" "rt-1b-private-generic" {

  route {
    cidr_block     = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.nat-1b.id
  }

  tags = {
    Name = "habil-dev-1b-private-generic-rt"
    CostCenter = "habil-dev-1b-private-generic-rt"
  }

  vpc_id = aws_vpc.vpc.id
}

resource "aws_route_table" "rt-1c-private-generic" {

  route {
    cidr_block     = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.nat-1c.id
  }

  tags = {
    Name = "habil-dev-1c-private-generic-rt"
    CostCenter = "habil-dev-1c-private-generic-rt"
  }

  vpc_id = aws_vpc.vpc.id
}





