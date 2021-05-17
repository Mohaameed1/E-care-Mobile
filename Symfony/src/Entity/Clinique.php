<?php

namespace App\Entity;

use App\Repository\CliniqueRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ORM\Entity(repositoryClass=CliniqueRepository::class)
 */
class Clinique
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     * @Groups("Clinique")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Ce champs est obligatoire")
     * @Groups("Clinique")
     */
    private $nomcl;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Ce champs est obligatoire")
     * @Groups("Clinique")
     */
    private $adressecl;

    /**
     *  @Assert\Length(
     *      min =8,
     *      max = 8,
     *      minMessage = "Votre numéro de téléphone ne contient pas {{ limit }} nombres",
     *      maxMessage = "Votre numéro ne doit pas dépasser  {{ limit }} nombres"
     * )
     * @ORM\Column(type="integer")
     * @Assert\NotBlank(message="Ce champs est obligatoire")
     * @Groups("Clinique")
     */
    private $numerocl;

    /**
    
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Ce champs est obligatoire")
     * @Groups("Clinique")
     */
    private $desccl;

    /**
     *
     */


    public function __construct()
    {


    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomcl(): ?string
    {
        return $this->nomcl;
    }

    public function setNomcl(string $nomcl): self
    {
        $this->nomcl = $nomcl;

        return $this;
    }

    public function getAdressecl(): ?string
    {
        return $this->adressecl;
    }

    public function setAdressecl(string $adressecl): self
    {
        $this->adressecl = $adressecl;

        return $this;
    }

    public function getNumerocl(): ?int
    {
        return $this->numerocl;
    }

    public function setNumerocl(int $numerocl): self
    {
        $this->numerocl = $numerocl;

        return $this;
    }

    public function getDesccl(): ?string
    {
        return $this->desccl;
    }

    public function setDesccl(string $desccl): self
    {
        $this->desccl = $desccl;

        return $this;
    }

    public function __toString()
{
    try {
       return (string) $this->attributeToReturn; // If it is possible, return a string value from object.
    } catch (Exception $e) {
       return get_class($this).'@'.spl_object_hash($this); // If it is not possible, return a preset string to identify instance of object, e.g.
    }
}

}
