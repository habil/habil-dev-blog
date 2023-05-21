terraform {
  required_version = ">= 0.12.0"
  backend  "s3" {
    bucket         = "habil-dev-bucket"
    key            = "prod/vpc/habil-dev.tfstate"
    region         = "eu-central-1"
  }
}

provider "aws" {
  version = "~> 4.0"
  region  = "eu-central-1"
}

module "vpc" {
  source = "./vpc"
}