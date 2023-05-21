resource "aws_internet_gateway" "gateway" {
  vpc_id = aws_vpc.vpc.id
  tags = {
    Name        = "habil-dev-igw"
    Environment = "dev"
    CostCenter  = "habil-dev-igw"
  }
}
